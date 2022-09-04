package UI.controller;

import Calculate.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import UI.myAlert;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;
import javafx.scene.input.KeyEvent;
public class Controller {//监听器
    @FXML
    private Button buttonAdd;
    @FXML
    private Button buttonSubtract;
    @FXML
    private Button buttonMultiplication;
    @FXML
    private Button buttonDivide;
    @FXML
    private Button buttonEqual;
    @FXML
    private TextField textFieldA;
    @FXML
    private TextField textFieldB;
    @FXML
    private Text text;
    @FXML
    public void onButtonClick(ActionEvent actionEvent){//按钮的点击事件，加减乘除和等于
        Button buttonClicked = (Button)actionEvent.getSource();
        String buttonText = buttonClicked.getText();
        System.out.println(buttonText);
        if (buttonText.equals("+")){
            CalculateType.setCalculateType(CalculateType.Add);
        }else if (buttonText.equals("-")){
            CalculateType.setCalculateType(CalculateType.Subtract);
        }else if (buttonText.equals("×")){
            CalculateType.setCalculateType(CalculateType.Multiplication);
        }else if (buttonText.equals("÷")){
            CalculateType.setCalculateType(CalculateType.Divide);
        }else{
            if (CalculateType.getCalculateType().isEmpty()){//没有按运算符
                myAlert.alertError("还没有选择运算符");
            }else {
                int numberA;
                if (textFieldA.getText() == null || textFieldA.getText().isEmpty()) {
                    numberA = 0;
                } else {
                    if (textFieldA.getText().length()>9){
                        myAlert.alertError("您输入的数字太大了");
                        return;
                    }
                    numberA = Integer.valueOf(textFieldA.getText());
                }
                int numberB;
                if (textFieldB.getText() == null || textFieldB.getText().isEmpty()) {
                    numberB = 0;
                } else {
                    if (textFieldB.getText().length()>9){
                        myAlert.alertError("您输入的数字太大了");
                        return;
                    }
                    numberB = Integer.valueOf(textFieldB.getText());
                }

                int result=0;
                if (CalculateType.getCalculateType().equals(CalculateType.Add)){
                    result= Add.add(numberA,numberB);
                }else if (CalculateType.getCalculateType().equals(CalculateType.Subtract)){
                    result= Subtract.subtract(numberA,numberB);
                }else if (CalculateType.getCalculateType().equals(CalculateType.Multiplication)){
                    result= Multiplication.multiplication(numberA,numberB);
                }else{
                    result= Divide.divide(numberA,numberB);
                    if (numberA!=0&&result==0){
                        return;
                    }
                }

                text.setText("结果："+result);
                CalculateType.setCalculateType("");
                textFieldA.setText(String.valueOf(result));
                textFieldB.setText("");
            }

        }
    }
    public void onButtonPressed(KeyEvent keyEvent) {

        if (keyEvent.getCode() == KeyCode.ENTER) {
            Button buttonClicked = (Button) keyEvent.getSource();
            String buttonText = buttonClicked.getText();
            System.out.println(buttonText);
            if (buttonText.equals("+")) {
                CalculateType.setCalculateType(CalculateType.Add);
            } else if (buttonText.equals("-")) {
                CalculateType.setCalculateType(CalculateType.Subtract);
            } else if (buttonText.equals("×")) {
                CalculateType.setCalculateType(CalculateType.Multiplication);
            } else if (buttonText.equals("÷")) {
                CalculateType.setCalculateType(CalculateType.Divide);
            } else {
                if (CalculateType.getCalculateType().isEmpty()) {//没有按运算符
                    myAlert.alertError("还没有选择运算符");
                } else {
                    int numberA;
                    if (textFieldA.getText() == null || textFieldA.getText().isEmpty()) {
                        numberA = 0;
                    } else {
                        if (textFieldA.getText().length()>9){
                            myAlert.alertError("您输入的数字太大了");
                            return;
                        }
                        numberA = Integer.valueOf(textFieldA.getText());
                    }
                    int numberB;
                    if (textFieldB.getText() == null || textFieldB.getText().isEmpty()) {
                        numberB = 0;
                    } else {
                        if (textFieldB.getText().length()>9){
                            myAlert.alertError("您输入的数字太大了");
                            return;
                        }
                        numberB = Integer.valueOf(textFieldB.getText());
                    }

                    int result = 0;
                    if (CalculateType.getCalculateType().equals(CalculateType.Add)) {
                        result = Add.add(numberA, numberB);
                    } else if (CalculateType.getCalculateType().equals(CalculateType.Subtract)) {
                        result = Subtract.subtract(numberA, numberB);
                    } else if (CalculateType.getCalculateType().equals(CalculateType.Multiplication)) {
                        result = Multiplication.multiplication(numberA, numberB);
                    } else {
                        result = Divide.divide(numberA, numberB);
                    }

                    text.setText("结果：" + result);
                    CalculateType.setCalculateType("");
                    textFieldA.setText("");
                    textFieldA.setText(""+result);
                    textFieldB.setText("");
                }

            }
        }
    }
}

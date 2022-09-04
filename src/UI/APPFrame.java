package UI;

import UI.controller.Controller;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.*;
import javafx.stage.Stage;

import Checker.isNumber;

public class APPFrame extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/AppUI.fxml"));//加载布局文件
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
        TextField textField1 = (TextField) parent.lookup("#textFieldA");
        TextField textField2 = (TextField) parent.lookup("#textFieldB");
        Button buttonAdd = (Button) parent.lookup("#buttonAdd");
        Button buttonSubtract = (Button) parent.lookup("#buttonSubtract");
        Button buttonMultiplication = (Button) parent.lookup("#buttonMultiplication");
        Button buttonDivide = (Button) parent.lookup("#buttonDivide");
        Button buttonEqual = (Button) parent.lookup("#buttonEqual");
        KeyCombination keyCombination0 = new KeyCodeCombination(KeyCode.DIGIT8,KeyCombination.SHIFT_DOWN);//用键盘输入运算符
        scene.getAccelerators().put(keyCombination0, new Runnable() {
            @Override
            public void run() {
                buttonMultiplication.fire();
            }
        });
        KeyCombination keyCombination1 = new KeyCodeCombination(KeyCode.EQUALS,KeyCombination.SHIFT_DOWN);//请切换到英文输入法
        scene.getAccelerators().put(keyCombination1, new Runnable() {
            @Override
            public void run() {
                buttonAdd.fire();
            }
        });
        KeyCombination keyCombination2 = new KeyCodeCombination(KeyCode.MINUS);//请切换到英文输入法
        scene.getAccelerators().put(keyCombination2, new Runnable() {
            @Override
            public void run() {
                buttonSubtract.fire();
            }
        });
        KeyCombination keyCombination3 = new KeyCodeCombination(KeyCode.SLASH);//请切换到英文输入法
        scene.getAccelerators().put(keyCombination3, new Runnable() {
            @Override
            public void run() {
                buttonSubtract.fire();
            }
        });
        KeyCombination keyCombination4 = new KeyCodeCombination(KeyCode.EQUALS);//请切换到英文输入法
        scene.getAccelerators().put(keyCombination4, new Runnable() {
            @Override
            public void run() {
                buttonEqual.fire();
            }
        });

        textField1.setOnKeyPressed(new EventHandler<KeyEvent>() {//好像本来就支持按tab切换
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode()==KeyCode.ENTER){
                    textField2.requestFocus();
                    textField2.isFocused();
                }
            }
        });
        textField2.setOnKeyPressed(new EventHandler<KeyEvent>() {//支持enter切换
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode()==KeyCode.ENTER){
                    textField1.requestFocus();
                    textField1.isFocused();
                }
            }
        });
        textField1.textProperty().addListener(new ChangeListener<String>() {//拒绝无效输入
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {//s=old value t1=new value
                if (isNumber.check(t1)){
               }else{
                    textField1.setText(t1);
                    textField1.setText(s);
                }
            }
        });
        textField2.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {//s=old value t1=new value
                if (isNumber.check(t1)){
                }else{
                    textField2.setText(t1);
                    textField2.setText(s);
                }
            }
        });
    }
}

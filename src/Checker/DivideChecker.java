package Checker;

import UI.myAlert;

public class DivideChecker {
    public static boolean divideChecker(int a,int b){//ture=输入有效；false=输入无效
        if (b==0){
            myAlert.alertError("除数不能为0");
            return false;
        }else {
            if (a%b==0) {//a能整除b
                return true;
            }else{
                myAlert.alertError("只支持整数除法");
                return false;
            }
        }
    }
}

package Checker;

public class isNumber {
    public static boolean check(String string){//检验字符是不是数字
        int i=(string.length()-1);
        for(int j=0;j<=i;j++) {
            char myChar = string.charAt(j);
            if ((myChar < '0') || (myChar > '9')) {
                return false;
            }
        }
        return true;
    }
}

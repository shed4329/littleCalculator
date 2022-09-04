package Calculate;

import Checker.DivideChecker;
public class Divide {//a除以b
    public static int divide(int a,int b){
        if(DivideChecker.divideChecker(a,b)){//检验输入是否有效
            return (a / b);
        }else{

            return 0;
        }
    }
}

package Calculate;

public class CalculateType {
    public static final String Add = "Add";//用字符串存储数据类型
    public static final String Subtract = "Subtract";
    public static final String Multiplication = "Multiplication";
    public static final String Divide = "Divide";
    static String calculateType = "";

    public static void setCalculateType(String str) {
        CalculateType.calculateType = str;
    }

    public static String getCalculateType() {
        return calculateType;
    }
}

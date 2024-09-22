package learning.aDataStucture.recusion;

public class SumOfDigits {

    public static void main(String[] args) {
        int fun = new SumOfDigits().fun(1234);
        System.out.println(fun);
    }

    private int fun(int num) {
        if (num == 0) {
            return 0;
        }
        return (num % 10) + fun(num / 10);
    }

}

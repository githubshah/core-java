package learning.aDataStucture.recusion;

public class SumOfDigits {

    public static void main(String[] args) {

        int fun = new SumOfDigits().fun(468);

        System.out.println(fun);
    }

    private int fun(int num) {

        if (num == 0) return 0;
        int rem = num % 10;
        return fun(num / 10) + rem;

    }

}

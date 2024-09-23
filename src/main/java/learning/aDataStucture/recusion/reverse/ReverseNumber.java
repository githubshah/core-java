package learning.aDataStucture.recusion.reverse;

public class ReverseNumber {

    public static void main(String[] args) {
        int s = 123;
        int fun = new ReverseNumber().fun(s);
        System.out.println(fun);
    }

    private int fun(int num) {
        if (num < 10) {
            return num;
        }
        return Integer.parseInt(num % 10 + "" + fun(num / 10));
    }

}

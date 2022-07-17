package learning.aDataStucture.recusion;

public class Factorial {

    public static void main(String[] args) {
        System.out.println(new Factorial().fun(5));
    }

    private int fun(int num) {

        if (num == 1) {
            return num;
        }

        return num * fun(num - 1);
    }
}

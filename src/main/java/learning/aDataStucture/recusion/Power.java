package learning.aDataStucture.recusion;

public class Power {

    public static void main(String[] args) {

        int s = 123;
        int fun = new Power().fun(2, 4);

        System.out.println(fun);
    }

    private int fun(int num, int power) {  // 2, 3

        if (power == 1) return num;
        return fun(num, power - 1) * num;

    }

}

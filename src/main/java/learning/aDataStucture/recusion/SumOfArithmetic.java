package learning.aDataStucture.recusion;

public class SumOfArithmetic {

    public static void main(String[] args) {

        int s = 123;
        int fun = new SumOfArithmetic().fun(1, 10);

        System.out.println(fun);
    }

    private int fun(int src, int dest) {  // 2, 3

        if (src == dest) return dest;
        return fun(src + 1, dest) + src;

    }

}

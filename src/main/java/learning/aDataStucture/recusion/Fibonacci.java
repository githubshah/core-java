package learning.aDataStucture.recusion;

public class Fibonacci {

    public static void main(String[] args) {
        int fun = new Fibonacci().fun(8, 0, 1, 0);
        System.out.println(">>> " + fun);
    }

    private int fun(int query, int i, int j, int count) {
        if (count == query) return j - i;
        System.out.println(i);
        return fun(query, j, i + j, count + 1);
    }
}

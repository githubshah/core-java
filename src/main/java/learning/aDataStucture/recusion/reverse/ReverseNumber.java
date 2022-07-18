package learning.aDataStucture.recusion.reverse;

public class ReverseNumber {

    public static void main(String[] args) {

        int s = 123;
        int fun = new ReverseNumber().fun(s, 100);

        System.out.println(fun);
    }

    private int fun(int num, int t) {

        /*
         *  int pre = num / t ;
         *  int newNum = num - (t * pre)
         *
         *  if ( newNum == 0) return pre ;
         *
         * */

        if (num == 0) return 0;

        int pre = num / t;

        return fun(num - (t * pre), t / 10) * 10 + pre;
    }

}

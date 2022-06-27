package demo;

public class Main {

    public static void main(String[] args) {
        System.out.println(new Main().reverse(1234));
    }

    static int ans = 0;

    private int reverse(int var) { //  1234
        if (var == 0) {
            return ans;
        }

        if (var > 0) {
            int temp = var % 10;
            ans = (ans * 10) + temp;
            reverse(var / 10);
        }

        // returning final answer when the number is
        // reversed completely
        return ans;
    }
}

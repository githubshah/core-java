package demo;

import java.util.Arrays;

public class Nain {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5,  8};
        int[] subset = new int[arr.length];
        new Nain().fun(arr, subset, 0, 0);
    }

    private void fun(int[] arr, int[] subset, int i, int sum) {
        if (i == arr.length) {
            if (sum == 8) {
                System.out.println(Arrays.toString(subset));
            }
            return;
        }

        subset[i] = arr[i];
        fun(arr, subset, i + 1, sum + arr[i]);
        subset[i] = 0;
        fun(arr, subset, i + 1, sum);
    }
}

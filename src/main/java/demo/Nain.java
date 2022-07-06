package demo;

import java.util.Arrays;

public class Nain {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 8};
        int[] subset = new int[arr.length];
        System.out.println(new Nain().fun(arr, subset, 0, 0));
    }

    private int fun(int[] arr, int[] subset, int i, int sum) {
        if (i == arr.length) {
            if (sum == 8) {
                System.out.println(Arrays.toString(subset));
                return 1;
            }
            return 0;
        }

        int count = 0;
        subset[i] = arr[i];
        count += fun(arr, subset, i + 1, sum + arr[i]);
        subset[i] = 0;
        count += fun(arr, subset, i + 1, sum);

        return count;
    }
}

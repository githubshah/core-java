package learning.aDataStucture.recusion.subset;


import java.util.Arrays;

public class FindPossibleSubSetSumEqualsToOptimized {

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 8};
        int[] subset = new int[arr.length];
        int query = 8;
        new FindPossibleSubSetSumEqualsToOptimized().fun(arr, subset, 0, 0, query);
    }

    private void fun(int[] arr, int[] subset, int i, int sum, int query) {
        if (i == arr.length) {
            if (sum == query) {
                System.out.println(Arrays.toString(subset));
            }
            return;
        }

        subset[i] = 0;
        fun(arr, subset, i + 1, sum, query);
        subset[i] = arr[i];
        fun(arr, subset, i + 1, sum + arr[i], query);
    }
}

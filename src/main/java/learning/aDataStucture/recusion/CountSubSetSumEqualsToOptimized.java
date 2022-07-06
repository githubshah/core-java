package learning.aDataStucture.recusion;


public class CountSubSetSumEqualsToOptimized {

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 8};
        int[] subset = new int[arr.length];
        int query = 8;
        int fun = new CountSubSetSumEqualsToOptimized().fun(arr, subset, 0, 0, query);
        System.out.println(fun);
    }

    private int fun(int[] arr, int[] subset, int i, int sum, int query) {
        if (i == arr.length) {
            if (sum == query) {
                //System.out.println(Arrays.toString(subset));
                return 1;
            }
            return 0;
        }

        int count = 0;

        subset[i] = 0;
        count += fun(arr, subset, i + 1, sum, query);
        subset[i] = arr[i];
        count += fun(arr, subset, i + 1, sum + arr[i], query);
        return count;
    }
}

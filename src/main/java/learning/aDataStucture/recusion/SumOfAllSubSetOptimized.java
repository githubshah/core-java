package learning.aDataStucture.recusion;


import java.util.ArrayList;
import java.util.List;

public class SumOfAllSubSetOptimized {

    public static void main(String[] args) {
        int[] arr = {2, 3, 5};
        List<Integer> subset = new ArrayList<>();
        new SumOfAllSubSetOptimized().fun(arr, subset, 0, 0);
        System.out.println(subset);
    }

    private void fun(int[] arr, List<Integer> subset, int i, int sum) {
        if (i == arr.length) {
            subset.add(sum);
            return;
        }

        fun(arr, subset, i + 1, sum);
        fun(arr, subset, i + 1, sum + arr[i]);
    }
}

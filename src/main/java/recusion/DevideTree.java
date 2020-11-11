package recusion;

import java.util.Arrays;

public class DevideTree {
    public static void main(String[] args) {
        int arr[] = {1, 11, 3, 4, 2};
        merger(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void merger(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            System.out.println("Left " + start + "-" + mid);
            merger(arr, start, mid);
            System.out.println("Right " + (mid + 1) + "-" + end);
            merger(arr, mid + 1, end);
            System.out.println(">>>>>leaves " + start + "-" + mid + "-" + end);
        }
    }
}

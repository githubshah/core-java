package learning.aDataStucture.recusion;

import java.util.Arrays;

public class Merge {
    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 2};
        merger(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void merger(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            merger(arr, start, mid);
            merger(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int n1 = mid - start + 1;
        int n2 = end - mid;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[start + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[mid + 1 + j];

        System.out.println(Arrays.toString(L));
        System.out.println(Arrays.toString(R));
        System.out.println("--------------");

        int k = start;
        int i = 0;
        int j = 0;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }
        while (i < n1) {
            arr[k++] = L[i++];
        }

        while (j < n2) {
            arr[k++] = R[j++];
        }
    }
}

package learning.aDataStucture.recusion.reverse;

import java.util.Arrays;

public class ReverseArray {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        new ReverseArray().fun(arr, -1);
        System.out.println("reverse order array");
        Arrays.stream(arr).forEach(System.out::println);
    }

    private void fun(int[] arr, int i) {

        if (i == arr.length - 1) {
            return;
        }

        fun(arr, ++i);
        arr[i] = arr.length - i;
    }

}

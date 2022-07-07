package learning.print_collection;

import java.util.Arrays;

public class ArrayToString {

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5};

        System.out.println(Arrays.toString(array));


        int[][] array1 = {{1, 2}, {3, 4}, {5, 6, 7}};

        System.out.println(Arrays.deepToString(array1));
    }
}

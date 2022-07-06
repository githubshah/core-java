package learning.aDataStucture.graph;

import java.util.HashSet;

public class MaxContribution {


    private static int countIsLand(int[][] arr, int r, int c) {

        if (r > arr.length - 1 || c > arr.length - 1) {
            return -1;
        }

        System.out.println(r + ":" + c);

        int i = countIsLand(arr, r + 1, c) < countIsLand(arr, r, c + 1) ? 0 : 0;
        System.out.println("-----");
        //int max = i >= j ? arr[r + 1][c] : arr[r][c + 1];

        return 0;

    }

    public static void main(String[] args) {
        int arr[][] = {{1, 6, 7}, {2, 5, 8}, {3, 4, 9}};

        HashSet<String> visited = new HashSet<>();

        int maximum = 0;
        int sum = countIsLand(arr, 0, 0);
        System.out.println(maximum);
    }


}

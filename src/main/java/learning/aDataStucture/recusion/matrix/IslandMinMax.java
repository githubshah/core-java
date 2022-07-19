package learning.aDataStucture.recusion.matrix;

import java.util.HashSet;

public class IslandMinMax {


    private static int countIsLand(int[][] arr, int r, int c, HashSet<String> visited) {

        if (r < 0 || r > arr.length - 1) {
            return 0;
        }

        if (c < 0 || c > arr[0].length - 1) {
            return 0;
        }

        if (arr[r][c] == 0) {
            return 0;
        }

        String pos = r + "," + c;
        if (visited.contains(pos)) {
            return 0;
        }

        visited.add(pos);

        int count = 1;

        count += countIsLand(arr, r - 1, c, visited);
        count += countIsLand(arr, r + 1, c, visited);
        count += countIsLand(arr, r, c - 1, visited);
        count += countIsLand(arr, r, c + 1, visited);
        count += countIsLand(arr, r + 1, c + 1, visited);
        count += countIsLand(arr, r - 1, c - 1, visited);
        count += countIsLand(arr, r + 1, c - 1, visited);
        count += countIsLand(arr, r - 1, c + 1, visited);

        return count;
    }

    public static void main(String[] args) {
        int[][] arr =
                {
                        {0, 1, 0, 0, 1},
                        {0, 1, 0, 1, 0},
                        {0, 0, 0, 1, 0},
                        {0, 0, 1, 1, 0},
                        {1, 0, 0, 1, 1},
                        {1, 1, 0, 0, 0},
                };


        int largest = 0;
        int smallest = 100;
        HashSet<String> visited = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                int size = countIsLand(arr, i, j, visited);
                if (size > largest) {
                    largest = size;
                }

                if (size < smallest && size != 0) {
                    smallest = size;
                }
            }
        }
        System.out.println(largest + ":" + smallest);
    }
}

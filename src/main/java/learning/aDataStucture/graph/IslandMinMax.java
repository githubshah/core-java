package learning.aDataStucture.graph;

import java.util.HashSet;

public class IslandMinMax {


    private static int countIsLand(char[][] arr, int r, int c, HashSet<String> visited, int ctr) {

        if (r < 0 || r >= arr.length) {
            return 0;
        }

        if (c < 0 || c >= arr[0].length) {
            return 0;
        }

        if (arr[r][c] == 'W') {
            return 0;
        }


        String pos = r + "," + c;
        if (visited.contains(pos)) {
            return 0;
        }

        visited.add(pos);

        int size = 1;

        size += countIsLand(arr, r - 1, c, visited, ctr);
        size += countIsLand(arr, r + 1, c, visited, ctr);
        size += countIsLand(arr, r, c - 1, visited, ctr);
        size += countIsLand(arr, r, c + 1, visited, ctr);
        size += countIsLand(arr, r + 1, c + 1, visited, ctr);
        size += countIsLand(arr, r - 1, c - 1, visited, ctr);
        size += countIsLand(arr, r + 1, c - 1, visited, ctr);
        size += countIsLand(arr, r - 1, c + 1, visited, ctr);

        return size;
    }

    public static void main(String[] args) {
        char arr[][] =
                {
                        {'W', 'L', 'W', 'W', 'L'},
                        {'W', 'L', 'W', 'L', 'W'},
                        {'W', 'L', 'W', 'L', 'W'},
                        {'W', 'W', 'L', 'L', 'W'},
                        {'L', 'W', 'W', 'L', 'L'},
                        {'L', 'L', 'W', 'W', 'W'},
                        {'W', 'W', 'W', 'L', 'W'},
                        {'W', 'L', 'L', 'W', 'W'},
                };


        int largest = 0;
        int smallest = 10;
        HashSet<String> visited = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                int ctr = 0;
                int size = countIsLand(arr, i, j, visited, ctr);
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

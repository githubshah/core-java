package learning.aDataStucture.recusion.matrix;

import java.util.HashSet;

public class IslandCount {


    private static boolean countIsLand(char[][] arr, int r, int c, HashSet<String> visited) {

        if (r < 0 || r > arr.length - 1) {
            return false;
        }

        if (c < 0 || c > arr.length - 1) {
            return false;
        }

        if (arr[r][c] == 'W') {
            return false;
        }

        String pos = r + "," + c;
        if (visited.contains(pos)) {
            return false;
        }

        visited.add(pos);

        countIsLand(arr, r - 1, c, visited);
        countIsLand(arr, r + 1, c, visited);
        countIsLand(arr, r, c - 1, visited);
        countIsLand(arr, r, c + 1, visited);
        countIsLand(arr, r + 1, c + 1, visited);
        countIsLand(arr, r - 1, c - 1, visited);
        countIsLand(arr, r + 1, c - 1, visited);
        countIsLand(arr, r - 1, c + 1, visited);

        return true;
    }

    public static void main(String[] args) {
        char arr[][] =
                {
                        {'W', 'L', 'W', 'W', 'L'},
                        {'W', 'L', 'W', 'L', 'W'},
                        {'W', 'W', 'W', 'L', 'W'},
                        {'W', 'W', 'L', 'L', 'W'},
                        {'L', 'W', 'W', 'L', 'L'},
                        {'L', 'L', 'W', 'W', 'W'},
                };


        int count = 0;
        HashSet<String> visited = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (countIsLand(arr, i, j, visited)) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }


}

package learning.aDataStucture.recusion.matrix;

import java.util.HashSet;
import java.util.Set;

class TotalPathInMatrix {
    public static int findLongestPath(int[][] mat, Set<String> visited, int i, int j) {

        if (i == mat.length - 1 && j == mat.length - 1) {
            return 1; // when it reached
        }

        if (i < 0 || i >= mat.length) {
            return 0;
        }

        if (j < 0 || j >= mat[0].length) {
            return 0;
        }

        if (mat[i][j] == 0) {
            return 0;
        }

        if (visited.contains(i + "," + j)) {
            return 0; // not reached
        }

        visited.add(i + "," + j);

        int count = 0;

        count += findLongestPath(mat, visited, i + 1, j);
        count += findLongestPath(mat, visited, i, j + 1);

        visited.remove(i + "," + j);

        return count;
    }

    public static void main(String[] args) {
        int mat[][] =
                {
                        {1, 1, 1, 1},
                        {1, 1, 0, 1},
                        {0, 1, 0, 1},
                        {1, 1, 1, 1}
                };

        Set<String> visitor = new HashSet<>();
        int max_dist = findLongestPath(mat, visitor, 0, 0);
        System.out.println("The maximum length path is " + max_dist);
    }
}

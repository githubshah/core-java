package learning.aDataStucture.recusion.matrix;

import java.util.HashSet;
import java.util.Set;

class LongestPathInMatrix {
    public static int findLongestPath(int[][] mat, Set<String> visited, int i, int j,
                                      int x, int y, int max_dist, int dist) {


        if (i < 0 || i > mat.length - 1) {
            return max_dist;
        }

        if (j < 0 || j > mat[0].length - 1) {
            return max_dist;
        }

        if (mat[i][j] == 0) {
            return max_dist;
        }

        if (i == x && j == y) {
            int max = Integer.max(dist, max_dist);
            System.out.println("    " + i + ":" + j + ">>                   > " + max);
            return max;
        }

        String pos = i + "," + j;
        if (visited.contains(pos)) {
            return max_dist;
        }

        visited.add(pos);

        max_dist = findLongestPath(mat, visited, i + 1, j, x, y, max_dist, dist + 1);
        max_dist = findLongestPath(mat, visited, i, j + 1, x, y, max_dist, dist + 1);
        max_dist = findLongestPath(mat, visited, i - 1, j, x, y, max_dist, dist + 1);
        max_dist = findLongestPath(mat, visited, i, j - 1, x, y, max_dist, dist + 1);

        System.out.println("    " + i + ":" + j + ">>           > " + max_dist);

        visited.remove(pos);

        return max_dist;
    }

    public static void main(String[] args) {
        int mat[][] =
                {
                        {1, 1, 1, 1, 0},
                        {1, 0, 1, 1, 0},
                        {1, 0, 1, 0, 0},
                        {1, 0, 1, 1, 0},
                        {1, 1, 0, 0, 0}
                };

        Set<String> visitor = new HashSet<>();
        int max_dist = findLongestPath(mat, visitor, 0, 0, 3, 3, 0, 1);
        System.out.println("The maximum length path is " + max_dist);
    }
}

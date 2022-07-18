package learning.aDataStucture.graph;

import java.util.HashSet;
import java.util.Set;

class LongestPathInMatrix {
    private static boolean isSafe(int[][] mat, Set<String> visitor, int i, int j) {
        return (i >= 0 && i < mat.length && j >= 0 && j < mat[0].length) &&
                mat[i][j] == 1 && !visitor.contains(i + "," + j);
    }

    public static int findLongestPath(int[][] mat, Set<String> visited, int i, int j,
                                      int x, int y, int max_dist, int dist) {

        if (i == x && j == y) {
            return Integer.max(dist, max_dist);
        }

        if (i < 0 || i >= mat.length) {
            return max_dist;
        }

        if (j < 0 || j >= mat[0].length) {
            return max_dist;
        }

        if (mat[i][j] == 0) {
            return max_dist;
        }

        if (visited.contains(i + "," + j)) {
            return max_dist;
        }

        visited.add(i + "," + j);

        max_dist = findLongestPath(mat, visited, i + 1, j, x, y, max_dist, dist + 1);
        max_dist = findLongestPath(mat, visited, i, j + 1, x, y, max_dist, dist + 1);
        max_dist = findLongestPath(mat, visited, i - 1, j, x, y, max_dist, dist + 1);
        max_dist = findLongestPath(mat, visited, i, j - 1, x, y, max_dist, dist + 1);

        visited.remove(i + "," + j);

        return max_dist;
    }

    public static void main(String[] args) {
        int mat[][] =
                {
                        {1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                        {1, 0, 1, 0, 1, 1, 1, 0, 1, 1},
                        {1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
                        {0, 0, 0, 0, 1, 0, 0, 1, 0, 0},
                        {1, 0, 0, 0, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                        {1, 0, 0, 0, 1, 0, 0, 1, 0, 1},
                        {1, 0, 1, 1, 1, 1, 0, 0, 1, 1},
                        {1, 1, 0, 0, 1, 0, 0, 0, 0, 1},
                        {1, 0, 1, 1, 1, 1, 0, 1, 0, 0}
                };

        Set<String> visitor = new HashSet<>();
        int max_dist = findLongestPath(mat, visitor, 0, 0, 5, 7, 0, 0);
        System.out.println("The maximum length path is " + max_dist);
    }
}

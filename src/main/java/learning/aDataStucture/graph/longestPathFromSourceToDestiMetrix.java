package learning.aDataStucture.graph;

import java.util.HashSet;
import java.util.Set;

class Main {
    private static boolean isSafe(int[][] mat, Set<String> visitor, int x, int y) {
        return (x >= 0 && x < mat.length && y >= 0 && y < mat[0].length) &&
                mat[x][y] == 1 && !visitor.contains(x + "," + y);
    }

    public static int findLongestPath(int[][] mat, Set<String> visited, int i, int j,
                                      int x, int y, int max_dist, int dist) {
        // if the destination is not possible from the current cell
        if (mat[i][j] == 0) {
            return 0;
        }

        // if the destination is found, update `max_dist`
        if (i == x && j == y) {
            return Integer.max(dist, max_dist);
        }

        visited.add(i + "," + j);

        if (isSafe(mat, visited, i + 1, j)) {
            max_dist = findLongestPath(mat, visited, i + 1, j, x, y, max_dist, dist + 1);
        }

        if (isSafe(mat, visited, i, j + 1)) {
            max_dist = findLongestPath(mat, visited, i, j + 1, x, y, max_dist, dist + 1);
        }

        if (isSafe(mat, visited, i - 1, j)) {
            max_dist = findLongestPath(mat, visited, i - 1, j, x, y, max_dist, dist + 1);
        }

        if (isSafe(mat, visited, i, j - 1)) {
            max_dist = findLongestPath(mat, visited, i, j - 1, x, y, max_dist, dist + 1);
        }

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

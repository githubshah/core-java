package learning.aDataStucture.recusion.matrix;

import java.util.HashSet;
import java.util.Set;

class TotalPathInMatrix {
    public static int findLongestPath(int[][] mat, Set<String> visited, int i, int j, int counter) {

        if (i < 0 || i > mat.length - 1) {
            return 0;
        }

        if (j < 0 || j > mat[0].length - 1) {
            return 0;
        }

        if (mat[i][j] == 0) {
            return 0;
        }

        if (i == mat.length - 1 && j == mat.length - 1) {
            mat[i][j] = counter;
            return 1;
        }

        String pos = i + "," + j;
        if (visited.contains(pos)) {
            return 0;
        }

        visited.add(pos);

        int count = 0;

        mat[i][j] = counter;

        count += findLongestPath(mat, visited, i + 1, j, counter + 1);
        count += findLongestPath(mat, visited, i, j + 1, counter + 1);

        visited.remove(i + "," + j);

        return count;
    }

    public static void main(String[] args) {
        int mat[][] =
                {
                        {1, 1, 0},
                        {1, 1, 1},
                        {1, 0, 1},
                };

        Set<String> visitor = new HashSet<>();
        int max_dist = findLongestPath(mat, visitor, 0, 0, 1);

        for (int i = 0; i < mat[0].length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("The maximum length path is " + max_dist);
    }
}

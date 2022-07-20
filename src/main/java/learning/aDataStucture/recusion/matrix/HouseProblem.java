package learning.aDataStucture.recusion.matrix;

public class HouseProblem {

    public static void main(String[] args) {

        int arr[][] = {
                {1, 2, 3},
                {4, 5, 6},
                {1, 9, 3}
        };

        int sum = new HouseProblem().fun(arr, 0, 0);
        System.out.println(sum);
    }

    private int fun(int[][] arr, int i, int j) {

        if (i > arr.length - 1 || j > arr.length - 1) {
            return 0;
        }

        if (i == arr.length - 1 && j == arr.length - 1) {
            return arr[arr.length - 1][arr.length - 1];
        }


        return arr[i][j] + Math.max(fun(arr, i + 1, j), fun(arr, i, j + 1));
    }
}

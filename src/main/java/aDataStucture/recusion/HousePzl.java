package aDataStucture.recusion;
public class HousePzl {
    public static void main(String[] args) {
        int arr[][] = {{1, 3}, {4, 5}, {2, 3}};

        System.out.println(findSum(arr, 0, 0, 0));
    }

    private static int findSum(int[][] arr, int i, int j, int sum) {
        System.out.println("i=" + i + ":j=" + j);
        if (i == 3 || j == 3) {
            return 0;
        } else if (i != 0 && i == j) {
            System.out.println("last: " + arr[i][j]);
            return sum + arr[i][j];
        } else {
            int left = findSum(arr, i, j + 1, sum);
            int down = findSum(arr, i + 1, j, sum);
            System.out.println(">>>>>>" + left + ":" + down);
            return (sum + Math.max(left, down));
        }
    }
}

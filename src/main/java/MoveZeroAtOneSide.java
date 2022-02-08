import java.util.Arrays;

public class MoveZeroAtOneSide {

    public static void main(String[] args) {
        int arr[] = {0, 1, 0, 1, 0, 1, 0, 0, 9, 0, 8, 9, 7, 8, 9, 0, 78, 9, 0, 7};
        System.out.println(Arrays.toString(arr));
        System.out.println("length if array: "+ arr.length);

        int counter = 0;
        int counter1 = 0;

        int i = 0;
        int j = arr.length - 1;
        counter = getCounter(Arrays.copyOfRange(arr, 0, arr.length), counter, i, j, 0);
        counter1 = getCounter1(Arrays.copyOfRange(arr, 0, arr.length), counter1, i, j, 0);

        System.out.println("number f swap : " + counter);
        System.out.println("number f swap : " + counter1);
        System.out.println("min number f swap : " + Math.min(counter, counter1));
    }

    private static int getCounter(int[] arr, int counter, int i, int j, int i1) {
        while (i < j) {
            i1++;
            if (arr[i] == 0 && arr[j] != 0) {
                swap(arr, i, j);
                counter++;
                i++;
                j--;
            }

            if (arr[i] != 0) ++i;
            if (arr[j] == 0) --j;
        }
        System.out.println(i1 + " >1> " + Arrays.toString(arr));
        return counter;
    }

    private static int getCounter1(int[] arr, int counter, int i, int j, int i1) {
        while (i < j) {
            i1++;
            if (arr[i] != 0 && arr[j] == 0) {
                swap(arr, i, j);
                counter++;
                i++;
                j--;
            }

            if (arr[i] == 0) ++i;
            if (arr[j] != 0) --j;
        }
        System.out.println(i1 + " >2> " + Arrays.toString(arr));
        return counter;
    }

    static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

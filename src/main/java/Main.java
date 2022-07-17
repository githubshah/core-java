import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {


        int arr[] = {1, 2, 3, 6, 3, 2, 1, 2, 7, 4};

        Integer[] array1 = new Integer[] {1, 2, 3, 6, 3, 2, 1, 2, 7, 4};

        List<Integer> test = Arrays.asList(array1);


        Map<Integer, Long> collect = test.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);


        //int secoundHeighestNumber = findSecoundHeighestNumber(arr);
        int secoundHeighestNumber1 = findSecoundHeighestNumberNew(arr);
        //System.out.println(secoundHeighestNumber);
    }

    private static int findSecoundHeighestNumberNew(int[] arr) {

        int i = 0;
        int j = arr.length - 1;

        final int[] largest = {0};
        final int[] secondLargest = {0};

        BiFunction<Integer, Integer, Integer> func = (ii, jj) -> {
            if (arr[ii] < arr[jj]) {
                if (secondLargest[0] < arr[jj]) {
                    if (largest[0] < arr[jj]) {
                        secondLargest[0] = largest[0];
                        largest[0] = arr[jj];
                    }
                }
            }
            return largest[0];
        };

        //arr = {1, 2, 3, 4, 3, 2, 1, 2};
        while (i < j) {

            fun(i, j, func);

            i++;
            j--;
        }

        System.out.println(largest[0]);
        System.out.println(secondLargest[0]);
        return 0;
    }

    private static void fun(int i, int j, BiFunction<Integer, Integer, Integer> func) {
        func.apply(i, j);
    }

    static int findSecoundHeighestNumber(int arr[]) {

        int highest = 0;
        int secondHighest = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > secondHighest) {
                if (arr[i] > highest) {
                    secondHighest = highest;
                    highest = arr[i];
                } else {
                    if (arr[i] != highest) {
                        secondHighest = arr[i];
                    }
                }
            }
        }
        System.out.println(highest);
        System.out.println(secondHighest);
        return secondHighest;
    }
}

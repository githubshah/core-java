package learning.aDataStucture.recusion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FindPossibleSubSetSumEqualsTo {
    static List<Integer> maxLength = new ArrayList<>();

    public static void main(String[] as) {
        Integer arr[] = new Integer[]{1, 2, 4, 2, 5, 1, 9};
        findSubSet(arr);
        System.out.println(maxLength);
    }

    private static void findSubSet(Integer[] arr) {
        Integer subSet[] = new Integer[arr.length];
        helper(arr, subSet, 0, 'r');
    }

    private static void helper(Integer[] arr, Integer[] subSet, int i, char x) {
        if (i == arr.length) {
            if (Arrays.stream(subSet)
                    .filter(Objects::nonNull)
                    .reduce(0, Integer::sum) == 10) {
                List<Integer> collect = Arrays.stream(subSet)
                        .filter(Objects::nonNull).collect(Collectors.toList());
                int size = collect.size();
                if (size > maxLength.size()) {
                    maxLength = collect;
                }
            }
        } else {
            subSet[i] = null;
            helper(arr, subSet, i + 1, 'l');
            subSet[i] = arr[i];
            helper(arr, subSet, i + 1, 'r');
        }
    }
}
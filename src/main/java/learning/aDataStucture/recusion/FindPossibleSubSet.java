package learning.aDataStucture.recusion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FindPossibleSubSet {
    static List<Integer> maxLength = new ArrayList<>();

    public static void main(String[] as) {
        Integer arr[] = new Integer[]{1, 2, 4};
        findSubSet(arr);
        System.out.println(maxLength);
    }

    private static void findSubSet(Integer[] arr) {
        Integer subSet[] = new Integer[arr.length];
        helper(arr, subSet, 0, 'r');
    }

    private static void helper(Integer[] arr, Integer[] subSet, int i, char x) {
        if (i == arr.length) {
            Predicate<Object> p = Objects::isNull;
            p.negate();
            System.out.println(Arrays.stream(subSet).filter(p.negate()).collect(Collectors.toList()));
        } else {
            subSet[i] = null;
            helper(arr, subSet, i + 1, 'l');
            subSet[i] = arr[i];
            helper(arr, subSet, i + 1, 'r');
        }
    }
}
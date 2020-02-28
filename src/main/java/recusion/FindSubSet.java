package recusion;

import java.sql.Date;
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FindSubSet {
    public static void main(String[] as) {
        Integer arr[] = new Integer[]{1, 2, 3, 6, 5, 7};
        int nano = LocalDateTime.now().getNano();
        findSubSet(arr);
        int nano1 = LocalDateTime.now().getNano();
        System.out.println(nano1-nano);
    }

    private static void findSubSet(Integer[] arr) {
        Integer subSet[] = new Integer[arr.length];
        helper(arr, subSet, 0);

    }

    private static void helper(Integer[] arr, Integer[] subSet, int i) {
        if (i == arr.length) {
            if(Arrays.stream(subSet)
                .filter(Objects::nonNull)
                .reduce(0, Integer::sum) == 10){
            System.out.println(Arrays.stream(subSet)
                .filter(Objects::nonNull).collect(Collectors.toList()));
            }
        } else {
            subSet[i] = null;
            helper(arr, subSet, i + 1);
            subSet[i] = arr[i];
            helper(arr, subSet, i + 1);
        }
    }
}

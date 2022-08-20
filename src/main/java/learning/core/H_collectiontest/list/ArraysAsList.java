package learning.core.H_collectiontest.list;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class ArraysAsList {

    public static void main(String[] args) {
        List<Integer> integers1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, null, null);

        //integers.add(11);// modification in size not allowed
        //integers.remove(1);// modification in size not allowed

        integers1.set(0,100);
        System.out.println(integers1);


        Integer []arr1 = {1, 2, 3, 1, 2, 3, 4, 2, 3, 4, 3, 4, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> integers = Arrays.asList(arr1);


        int []arr2 = {1, 2, 3, 1, 2, 3, 4, 2, 3, 4, 3, 4, 4, 5, 6, 7, 8, 9, 10};
        // not possible for primitive type
        List<int[]> ints = Arrays.asList(arr2);

        // java 8
        List<Integer> collect = Arrays.stream(arr2)
                .boxed()
                .collect(Collectors.toList());


    }
}

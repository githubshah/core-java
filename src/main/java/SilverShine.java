import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

import static java.util.Collections.*;

public class SilverShine {

    public static void main(String[] args) {
        int a[] = {1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1};
        //int b[] = {1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1};
        //reverse(Arrays.asList(b));
        //System.out.println(Math.min(call(a), reverse(Arrays.asList(a))));
    }

    private static int call(int a[]) {
        int result = 0;
        int i = 0;

        int j = a.length - 1;
        while (i < j) {
            if (i == 0) {
                if (a[i] == a[j]) {
                    i++;
                } else {
                    i++;
                    j--;
                }
            } else {
                if (a[i] == a[j]) {
                    if (a[i - 1] == a[i]) {
                        i++;
                    } else {
                        j--;
                    }
                } else {
                    if (a[i - 1] == a[i]) {
                        i++;
                    } else {
                        ++result;
                        //System.out.println("i: " + i + ", j: " + j);
                        swap(i, j, a);
                        i++;
                        j--;
                    }
                }
            }
        }

        return result;
    }

    private static void swap(int i, int j, int[] a) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

package recusion;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.sort;

public class Merge {
    public static void main(String[] args) {
        int a[] = {2, 6};
        int b[] = {4, 1};
        int[] merge = merge(a, 0, 1, b, 0, 1);
        System.out.println(Arrays.toString(merge));
    }

    private static int[] merge(int[] a, int x1, int x2, int[] b, int y1, int y2) {
        sort(a);
        sort(b);

        int[] abc = new int[4];
        int k = 0;
        while (x1 <= x2 && y1 <= y2) {
            if (a[x1] <= b[y1]) {
                abc[k++] = a[x1++];
            } else {
                abc[k++] = b[y1++];
            }
        }
        while (x1 <= x2) {
            abc[k++] = a[x1++];
        }

        while (y1 <= y2) {
            abc[k++] = a[y1++];
        }
        return abc;
    }
}

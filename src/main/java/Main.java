public class Main {

    public static void main(String[] args) {
        int a[] = {1, 2, 4, 4, 15, -13, -1, 6, 9};
        int max = a[0], max2 = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max2) {
                max2 = a[i];
                if (max2 > max) {
                    int temp = max;
                    max = max2;
                    max2 = temp;
                }
            }
        }
        System.out.println(max);
        System.out.println(max2);
    }
}

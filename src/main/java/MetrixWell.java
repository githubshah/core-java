public class MetrixWell {

    static int x_axis = 5;
    static int y_axis = 5;
    static int ctr = 0;
    static int x1 = 2;
    static int y1 = 2;
    static int arr[][];

    public static void main(String[] args) {
        arr = new int[x_axis][y_axis];
        for (int k = 0; k < x_axis; k++)
            for (int l = 0; l < x_axis; l++)
                arr[k][l] = 0;

        arr[x1][y1] = ++ctr;

        while (ctr < 8) {
            while (!goUp()) ;
            while (!goRight()) ;
            while (!goDown()) ;
            while (!goLeft()) ;
        }
        System.out.println("hihi");
        print12(arr, x_axis);
    }

    static boolean goUp() {
        System.out.println("go up x:" + x1 + " ,y" + y1);
        if (arr[x1 - 1][y1] == 0) {
            arr[x1 - 1][y1] = ++ctr;
            --x1;
            return true;
        } else {
            return false;
        }
    }

    static boolean goRight() {
        System.out.println("go right x:" + x1 + " ,y" + y1);
        if (arr[x1][y1 + 1] == 0) {
            arr[x1][y1 + 1] = ++ctr;
            ++y1;
            return true;
        } else {
            return false;
        }
    }

    static boolean goDown() {
        System.out.println("go down x:" + x1 + " ,y" + y1);
        if (arr[x1 - 1][y1] == 0) {
            arr[x1 + 1][y1] = ++ctr;
            ++x1;
            return true;
        } else {
            return false;
        }
    }

    static boolean goLeft() {
        System.out.println("go left x:" + x1 + " ,y" + y1);
        if (arr[x1][y1] == 0) {
            arr[x1][y1] = ++ctr;
            return true;
        } else if (arr[x1][y1 - 1] == 0) {
            arr[x1][y1 - 1] = ++ctr;
            --y1;
            return true;
        } else {
            ++x1;
            return false;
        }
    }

    private static void print12(int[][] arr, int x) {
        for (int k = 0; k < x; k++) {
            for (int l = 0; l < x; l++)
                System.out.print("\t" + arr[k][l]);
            System.out.println();
        }
    }
}

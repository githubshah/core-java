import java.util.Scanner;

public class Main {
    /*
    n=3
      *
     ***
    *****

    n=2
     *
    ***

     */
    public static void main(String[] args) {

        Scanner l = new Scanner(System.in);
        int input = l.nextInt();

        //  1, 3, 5
        int x = 1;
        for (int i = 1; i <= input; i++) {
            //int x = i;
            for (int p = i; p < input; p++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= x; k++) {
                System.out.print("*");
            }
            System.out.println();
            x = x + 2;
        }
    }
}

package learning;

public class PossibleCombinationOfString {

    public static void main(String as[]) {

        char[] set = {'a', 'b', 'c'};
        int setSize = 3;

        long pow_set_size = (long) Math.pow(2, setSize); // possible consecutive char combination
        int counter, j;

        for (counter = 1; counter < pow_set_size; counter++) {
            System.out.print(counter +" = ");
            for (j = 0; j < setSize; j++) {
                if ((counter & (1 << j)) > 0)
                    System.out.print(set[j]);
            }
            System.out.println();
        }
    }
}

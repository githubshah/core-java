package learning.aDataStucture.charOccerence;

public class CharOccurrence {

    public static void main(String[] args) {
        char[] input = {'a', 'b', 'c', 'a', 'b', 'd', 'a', 'a', 'b', 'c', 'a', 'b', 'd', 'a'};
        char searchingChar = 'a';
        System.out.printf("character '%s' comes %d times\n", searchingChar, findOccurrence(input, searchingChar));
    }

    private static int findOccurrence(char[] input, char searchChar) {
        int[] output = new int[input.length];
        for (char value : input) {
            int index = value - 'a';
            output[index] = ++output[index];
        }
        return output[searchChar - 'a'];
    }
}

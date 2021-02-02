package learning.pattern.state;

public class Rainbow {
    public static void main(String[] args) {
        Color color = new Color(Alphabet.A);
        for (int i = 1; i <= 7; i++) {
            System.out.println(color.getNextColor());   //1,2,3,1,2,3,1
        }

        System.out.println("");

        Color color2 = new Color(Alphabet.B);
        System.out.println(color2.getNextColor());
        System.out.println(color2.getNextColor());
        System.out.println(color2.getNextColor());

        System.out.println("");
    }
}

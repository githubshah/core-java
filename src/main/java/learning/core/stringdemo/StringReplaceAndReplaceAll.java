package learning.core.stringdemo;

public class StringReplaceAndReplaceAll {

    public static void main(String[] args) {

        replaceAll(); // can pass regex

        replace(); // can not pass regex

        repalceOnRegex(); // not works
    }

    private static void replaceAll() {
        String myString = "__1_6____3__6_345____0";

        String regex = "\\d";
        String replacement = "x";

        String newString = myString.replaceAll(regex, replacement);
        // __x_x____x__x_xxx____x
        System.out.println("replaceAll: "+newString);
    }

    private static void replace() {
        String myString = "one fish, two fish, three fish";

        String target = "fish";
        String replacement = "sheep";

        String newString = myString.replace(target, replacement);
        System.out.println("replace: "+newString);
    }

    private static void repalceOnRegex() {
        String myString = "__1_6____3__6_345____0";

        String regex = "\\d";
        String replacement = "x";

        String newString = myString.replace(regex, replacement);
        // __x_x____x__x_xxx____x
        System.out.println("repalceOnRegex: "+newString);
    }
}

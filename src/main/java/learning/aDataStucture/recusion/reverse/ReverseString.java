package learning.aDataStucture.recusion.reverse;

public class ReverseString {

    public static void main(String[] args) {

        String s = "welcome";
        char[] chars = s.toCharArray();
        String fun = new ReverseString().fun(chars, 0);

        System.out.println(fun);
    }

    private String fun(char[] chars, int i) {

        if (i == chars.length) {
            return "";
        }

        return fun(chars, i+1) + chars[i];
    }

}

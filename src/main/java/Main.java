public class Main {

    public static void main(String[] args) {

        String s = "welcome";
        char[] chars = s.toCharArray();
        String fun = new Main().fun(chars, -1);

        System.out.println(fun);
    }

    private String fun(char[] chars, int i) {

        if (i == chars.length - 1) {
            return "";
        }

        i++;
        return fun(chars, i) + chars[i];
    }

}

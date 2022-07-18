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
        char aChar = chars[i];
        String fun = fun(chars, i);
        if(Character.isDigit(aChar)){
            return aChar + fun;
        }else{
            return fun + aChar;
        }
    }

}

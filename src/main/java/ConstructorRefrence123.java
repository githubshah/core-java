
import java.util.Stack;

public class ConstructorRefrence123 {
    public static void main(String args[]) {

//        String str1 = "xy#z";
//        String str2 = "xzz#";

        String str1="xy#z";
        String str2="xyz#";

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        Stack<Character> stack1 = new Stack();
        Stack<Character> stack2 = new Stack();

        int i = 0;
        int j = 0;
        while (i < chars1.length || j < chars2.length) {
            if (i < str1.length()) {
                if (str1.charAt(i) == '#' && !stack1.empty()) {
                    stack1.pop();
                } else {
                    stack1.push(chars1[i]);
                }
                i++;
            }

            if (j < str2.length()) {
                if (str2.charAt(j) == '#' && !stack2.empty()) {
                    stack2.pop();
                } else {
                    stack2.push(chars2[j]);
                }
                j++;
            }


        }
        System.out.println("Two string are same : " + checkIfTwoStackAreSame(stack1, stack2));

    }

    static boolean checkIfTwoStackAreSame(Stack<Character> stack1, Stack<Character> stack2) {

        if (stack1.size() != stack2.size()) {
            return false;
        }

        while (!stack1.empty()) {
            boolean equals = stack1.pop().equals(stack2.pop());
            if (!equals) {
                return false;
            }
        }
        return true;
    }
}

package learning.aDataStucture;

import java.util.ArrayDeque;

public class ParanthesisBalanced {

    public static void main(String[] args) {
        String str = "[]()[(())]";
        if (extracted(str)) {
            System.out.println("balanced");
        } else {
            System.out.println("not-balanced");
        }
    }

    private static boolean extracted(String str) {
        char[] chars = str.toCharArray();
        ArrayDeque<Character> stack = new ArrayDeque();

        for (char aChar : chars) {
            if (aChar == '(' || aChar == '[' || aChar == '{') {
                stack.push(aChar);
            } else if (aChar == ')' || aChar == ']' || aChar == '}') {
                if (stack.isEmpty() || !bracketEqual(stack.peek(), aChar)) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean bracketEqual(Character open, Character close) {
        if (open == '(' && close == ')') {
            return true;
        } else if (open == '[' && close == ']') {
            return true;
        } else {
            return open == '{' && close == '}';
        }
    }
}

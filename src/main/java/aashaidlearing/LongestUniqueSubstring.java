package aashaidlearing;

import java.util.HashMap;

public class LongestUniqueSubstring {

    public static int longestUniqueSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int start = 0;

        for (int end = 0; end < s.length(); end++) {  // abcdaef
            char currentChar = s.charAt(end);
            if (map.containsKey(currentChar)) {
                start = Math.max(start, map.get(currentChar) + 1);
            }
            map.put(currentChar, end);
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) { // 7 1 3
        // Test cases
        String input1 = "abcdecklmn";
        System.out.println("Length of longest substring without repeating characters: " + longestUniqueSubstring(input1));

        String input2 = "bbbbb";
        System.out.println("Length of longest substring without repeating characters: " + longestUniqueSubstring(input2));

        String input3 = "pwwkew";
        System.out.println("Length of longest substring without repeating characters: " + longestUniqueSubstring(input3));
    }
}

package learning.aDataStucture;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

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

    public static void main(String[] args) {
        String s = "abcdedcba";
        char[] chars = s.toCharArray();
        // 23:42
        int max = 0;
        for (int k = 0; k < s.length(); k++) {
            int i = k;
            Set<Character> set = new HashSet<>();
            while (i < s.length()) {
                if (set.contains(chars[i])) {
                    int size = set.size();
                    if (max < size) {
                        max = size;
                    }
                    break;
                } else {
                    set.add(chars[i]);
                    i++;
                }
            }
            if (max < set.size()) {
                max = set.size();
            }
        }
        System.out.println(max);

    }
}

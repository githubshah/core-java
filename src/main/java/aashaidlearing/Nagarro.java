package aashaidlearing;

import java.util.HashSet;
import java.util.Set;

public class Nagarro {

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

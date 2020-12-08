public class Snapdeal {

    public static void main(String[] args) {

        // A = "123" => 123
        // B = "12abc" => 12
        // C = "abc12abc" => exception
        // D = "a1b2" => exception
        // E = "a 12a"  => exception
        // F = null  || " " => exception
        // Z large String

        Integer output = toNumber("1239");
        System.out.println(output);
    }

    static Integer toNumber(String input) {

        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("input should not be null or empty!");
        }

        char[] chars = input.toCharArray();
        int lengthOfStr = chars.length;

        int sum = 0;
        boolean sequence = false;
        for (int i = 0; i < lengthOfStr; i++) {
            if (sum != 0 && !sequence) {
                throw new IllegalArgumentException("Input contains space or alphabates!");
            }

            char aChar = chars[i];  // abc1239
            if (aChar >= 48 && aChar <= 57) {
                if (sum != 0) {
                    sum = sum * 10;
                }

                sequence = true;
                int number = aChar - 48;
                sum = sum + number;  // 123
            } else {
                sequence = false;
            }
        }
        return sum;
    }
}

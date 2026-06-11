class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int[] index = new int[1];
        return helper(chars, index);
    }

    private int helper(char[] chars, int[] index) {
        int result = 0;
        int sign = 1;
        int n = chars.length;

        while (index[0] < n) {
            char c = chars[index[0]];

            if (c == ' ') {
                index[0]++;
                continue;
            }

            if (c >= '0' && c <= '9') {
                int num = c - '0';
                while (index[0] + 1 < n && chars[index[0] + 1] >= '0' && chars[index[0] + 1] <= '9') {
                    num = num * 10 + (chars[index[0] + 1] - '0');
                    index[0]++;
                }
                result += num * sign;
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '(') {
                index[0]++;
                result += sign * helper(chars, index);
            } else if (c == ')') {
                return result;
            }
            index[0]++;
        }

        return result;
    }
}
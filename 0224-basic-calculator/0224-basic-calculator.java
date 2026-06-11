class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        char[] chars = s.toCharArray();
        int n = chars.length;
        
        int[] stack = new int[n];
        int top = 0;
        
        int result = 0;
        int sign = 1;
        
        for (int i = 0; i < n; i++) {
            char c = chars[i];
            
            if (c >= '0' && c <= '9') {
                int num = c - '0';
                while (i + 1 < n && chars[i + 1] >= '0' && chars[i + 1] <= '9') {
                    num = num * 10 + (chars[i + 1] - '0');
                    i++;
                }
                result += num * sign;
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '(') {
                stack[top++] = result;
                stack[top++] = sign;
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result *= stack[--top];
                result += stack[--top];
            }
        }
        
        return result;
    }
}
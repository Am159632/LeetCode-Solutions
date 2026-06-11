class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        
        char[] chars = s.toCharArray();
        int n = chars.length;
        
        int j = 0;
        int[] pi = new int[n];
        
        for (int i = 1; i < n; i++) {
            while (j > 0 && chars[i] != chars[j]) {
                j = pi[j - 1];
            }
            if (chars[i] == chars[j]) {
                j++;
            }
            pi[i] = j;
        }
        
        int matched = 0;
        for (int i = n - 1; i >= 0; i--) {
            while (matched > 0 && chars[i] != chars[matched]) {
                matched = pi[matched - 1];
            }
            if (chars[i] == chars[matched]) {
                matched++;
            }
        }
        
        if (matched == n) {
            return s;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= matched; i--) {
            sb.append(chars[i]);
        }
        sb.append(s);
        
        return sb.toString();
    }
}
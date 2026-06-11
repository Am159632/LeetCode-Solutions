class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        
        String reversed = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + reversed;
        int[] pi = buildPiArray(combined);
        
        int longestPalindromicPrefixLength = pi[combined.length() - 1];
        String suffixToAdd = reversed.substring(0, s.length() - longestPalindromicPrefixLength);
        
        return suffixToAdd + s;
    }
    
    private int[] buildPiArray(String str) {
        int n = str.length();
        int[] pi = new int[n];
        int j = 0;
        
        for (int i = 1; i < n; i++) {
            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = pi[j - 1];
            }
            
            if (str.charAt(i) == str.charAt(j)) {
                j++;
            }
            
            pi[i] = j;
        }
        
        return pi;
    }
}
class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        
        // 1. Create the reversed version of the original string
        String reversed = new StringBuilder(s).reverse().toString();
        
        // 2. Combine them with a special separator character '#'.
        // This ensures the KMP prefix function won't match characters beyond the boundaries of 's'.
        String combined = s + "#" + reversed;
        
        // 3. Build the KMP Lookup Table (the Pi / LPS array) for the combined string
        int[] pi = buildPiArray(combined);
        
        // The last element of the Pi array tells us the length of the 
        // longest prefix of 's' that matches the suffix of 'reversed'.
        // Mathematically, this is the longest palindromic prefix starting at index 0.
        int longestPalindromicPrefixLength = pi[combined.length() - 1];
        
        // 4. Extract the characters that are not part of the palindromic prefix.
        // We take them from the beginning of the reversed string and append them to the front.
        String suffixToAdd = reversed.substring(0, s.length() - longestPalindromicPrefixLength);
        
        return suffixToAdd + s;
    }
    
    // Standard KMP Prefix Function - Runs in O(n) using Amortized Analysis (the Bank Principle)
    private int[] buildPiArray(String str) {
        int n = str.length();
        int[] pi = new int[n];
        
        // j tracks the length of the current maximum prefix-suffix match
        int j = 0;
        
        // i scans through the string from left to right (always moves forward)
        for (int i = 1; i < n; i++) {
            // Mismatch logic: if characters don't match, use previous computations in the pi array
            // to fall back ("jump back") to the next best smaller match instead of resetting to 0.
            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = pi[j - 1];
            }
            
            // Match logic: if characters match, extend the length of the current match
            if (str.charAt(i) == str.charAt(j)) {
                j++;
            }
            
            // Store the computed match length for the current state
            pi[i] = j;
        }
        
        return pi;
    }
}
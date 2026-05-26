class Solution {
    public String longestPalindrome1(String s) {
        int[][]d=new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++)d[i][i]=1;
        for(int i=s.length()-1;i>=0;i--){
            for(int j=i+1;j<s.length();j++){
                if(i==j-1 &&  s.charAt(i)==s.charAt(j)) d[i][j]=1;
                if(d[i+1][j-1]==1 && s.charAt(i)==s.charAt(j)) d[i][j]=1;
            }
        }
        int maxI=0,maxJ=0;
        for(int i=0;i<s.length();i++){
            for(int j=0;j<s.length();j++){
                if(d[i][j]==1 && j-i>maxJ-maxI){
                    maxI=i;
                    maxJ=j;
                }
            }
        }
        return s.substring(maxI,maxJ+1);
    }
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, max = 0;
        
        for (int k = 0; k < s.length(); k++) {
            int len1 = expand(s, k, k);
            int len2 = expand(s, k, k + 1);
            
            int len = Math.max(len1, len2);
            
            if (len > max) {
                max = len;
                start = k - (len - 1) / 2;
            }
        }
        
        return s.substring(start, start + max);
    }
    private int expand(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }
}
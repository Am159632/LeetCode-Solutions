class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        if(x==0) return true;

        int digits=digits(x);
        while (x>0){
            int l=x%10;
            int m=x/(int)(Math.pow(10,digits-1));
            if(l!=m) return false;
            x=x%(int) (Math.pow(10,digits-1));
            x=x/10;
            digits-=2;
        }
        return true;

    }
    public int digits(int x){
        int digits=0;
        while(x>0){
            x=x/10;
            digits++;
        }
        return digits;
    }
}
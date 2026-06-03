class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        
        // שלב 1: ריצה משמאל לימין (מילוי ה-Prefix)
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        
        // שלב 2: ריצה מימין לשמאל (עדכון עם ה-Suffix בתוך משתנה בודד)
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= rightProduct;
            rightProduct *= nums[i]; // מעדכנים את המכפלה מימין לאיטרציה הבאה
        }
        
        return res;
    }
}
class Solution {
    public int countOrders(int n) {
        long res = 1;
        long mod = 1_000_000_007;
        
        for (int i = 1; i <= n; i++) {
            
            // Combinatorially, adding the i-th order into 2*(i-1) existing slots
            // gives exactly: i * (2*i - 1) unique valid options for (P_i, D_i)
            long currentMultiplier = (long) i * (2 * i - 1);
            
            // Apply modulo operation at each step to maintain technical accuracy 
            // and keep the value within safety bounds of the long data type
            res = (res * currentMultiplier) % mod;
        }
        
        return (int) res; 
    }
}
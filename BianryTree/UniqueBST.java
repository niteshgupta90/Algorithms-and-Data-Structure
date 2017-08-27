//Number of Unique Binary Search Tress/Catalan Numbers
class Solution {
    public int numTrees(int n) {
        int res = 0;
        if(n==0)
            return 0;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        //dp[2] = 2;
        for(int len=2;len<=n;len++){
            for(int i=1;i<=len;i++){
                dp[len] +=  dp[i-1]*dp[len-i];
            }
        }
        return dp[n];
    }
}

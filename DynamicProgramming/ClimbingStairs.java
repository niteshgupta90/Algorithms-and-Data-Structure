//Climbing Stairs with n steps.
public class Solution {
    public int climbStairs(int n) {
        int res = 0;
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        int oneLess = 1;
        int twoLess = 2;
        for(int i=3;i<=n;i++){
            res = oneLess + twoLess;
            oneLess = twoLess;
            twoLess = res;
        }
        return res;
    }
}

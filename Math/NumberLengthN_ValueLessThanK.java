//Numbers of length N and value less than KBookmark Suggest Edit

public class Solution {
    public int res = 0;
    
    public int solve(ArrayList<Integer> A, int B, int C) {
        int num = 0;
        int numLength = 0;
        int val = C;
        int cLength = 0;
        int size = A.size();
        boolean isFirst = true;
        while(val>0){
            val=val/10;
            cLength++;
        }
        
        if(B==1){
            for(int i=0;i<size;i++){
                if(A.get(i)<C){
                    res++;
                }
            }
            return res;
        }
        if(B>cLength){
            return res;
        }
        if(B<cLength){
            if(A.contains(0)){
                res = size-1;
                for(int j=0;j<B-1;j++){
                    res = res * size;
                }
                return res;
            }
            else{
                res = 1;
                for(int j=0;j<B;j++){
                    res = res * size;
                }
                return res;
            }
        }
        if(B==cLength){
            solve(A, num, cLength, B, C,isFirst);
        }
        return res;
    }
    
    public void solve(ArrayList<Integer> A, int num, int cLength, int B, int C, boolean isFirst) {
        int[] lower = new int[10];
        for(int i=0;i<10;i++){
            for(int j=0;j<A.size();j++){
                if(A.get(j)<i)
                    lower[i]++;
            }
        }
        int[] digit = new int[cLength];
        for(int i = cLength-1;i>=0;i--){
            digit[i]=C%10;
            C=C/10;
        }
        int[] dp= new int[B+1];
        dp[0]=0;
        dp[1]=lower[digit[0]];
        if(A.contains(0) && dp[1]>0)
            dp[1]--;
        for(int i=2;i<=B;i++){
            dp[i]+=dp[i-1]*A.size();
            int j=0;
            for(;j<i-1;j++){
                if(A.contains(digit[j])==false)
                    break;
            }
            if(j==i-1)
                dp[i]+=lower[digit[i-1]];
        }
        res = dp[B];
    }
}

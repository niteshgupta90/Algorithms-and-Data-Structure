//Find possible unique Paths.
public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] arr = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    arr[0][0] = 1;
                }
                else if(i==0){
                    arr[i][j] =  arr[i][j-1];
                }
                else if(j==0){
                    arr[i][j] =  arr[i-1][j];
                }
                else
                    arr[i][j] = arr[i-1][j]+arr[i][j-1];
            }
        }
        return arr[m-1][n-1];
    }
    
    //top down DP
    // public int uniquePaths(int m, int n, int[][] arr) {
    //     if(m==1&&n==1)
    //         return 1;
    //     if(m<0 || n<0)
    //         return 0;
    //     if(arr[m][n]!=0)
    //         return arr[m][n];
    //     arr[m][n] = uniquePaths(m-1,n,arr) + uniquePaths(m,n-1,arr);
    //     return arr[m][n];
    // }
    
}

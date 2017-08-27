//Minimum number of steps required to convert word1 to word2 with operations:
//Insert, Delete and Replace
public class Solution {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        
        //int[] minDist = new int[l1];
        int[][] minDist = new int[l1][l2];
        return minDistance(word1,word2,l1-1,l2-1,minDist);
    }
    public int minDistance(String word1, String word2, int i, int j, int[][] minDist) {
        
        if(i<0)
            return j+1;
        if(j<0)
            return i+1;
        if(minDist[i][j]>0){
            return minDist[i][j];
        }
        int replace = 0;
        int delete = 0;
        int insert = 0;
        if(word1.charAt(i)==word2.charAt(j))
        {
            return minDistance(word1,word2,i-1,j-1,minDist);
        }
        replace = minDistance(word1,word2,i-1,j-1,minDist);
        delete = minDistance(word1,word2,i-1,j,minDist);
        insert = minDistance(word1,word2,i,j-1,minDist);
        minDist[i][j] = 1+Math.min(Math.min(replace,delete),insert);
        return minDist[i][j];
    }
}

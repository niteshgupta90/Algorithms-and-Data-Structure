//Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j]
public class Solution {
    // DO NOT MODIFY THE LIST
    public int maximumGap(final List<Integer> a) {
        int size = a.size();
        int maxDist = -1;
        int[] maxVal = new int[size];
        int[] minVal = new int[size];
        int[] dist = new int[size];
        minVal[0] = a.get(0);
        maxVal[size-1] = a.get(size-1);
        for(int i=1;i<size;i++ ){
            minVal[i] = Math.min(a.get(i),minVal[i-1]);
        }
        
        for(int j=size-2;j>=0;j--){
            maxVal[j] = Math.max(a.get(j),maxVal[j+1]);
        }
        int i=0;
        int j=0;
        while(i<size&&j<size){
            if(maxVal[j]>=minVal[i]){
                maxDist = Math.max(j-i,maxDist);
                j++;
            }
            else{
                i++;
            }
            
        }
        return maxDist;
    }
}

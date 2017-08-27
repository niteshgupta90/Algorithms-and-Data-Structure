//Maximum Sum Contiguous Subarray
public class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if(len==0)
            return 0;
        int maxAtIndex = nums[0];
        int maxOverall = nums[0];
        for(int i=1;i<len;i++){
            maxAtIndex =  Math.max(maxAtIndex+nums[i],nums[i]);
            maxOverall =  Math.max(maxOverall,maxAtIndex);
            
        }
        return maxOverall;
    }
}

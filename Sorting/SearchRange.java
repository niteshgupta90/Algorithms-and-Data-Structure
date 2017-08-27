//Search for a Range in O(logn)
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        int mid  = 0;
        int[] res = {-1,-1};
        if(n==0)
            return res;
        while(low<high){
            mid = low+(high-low)/2;
            if(nums[mid]<target){
                low = mid+1;
            }
            else{
                high = mid;
            }
        }
        if(nums[low]==target)
            res[0] = low;
        high = n-1;
        while(low<high){
            mid = low+(high-low)/2+1;
            if(nums[mid]>target){
                high = mid-1;
            }
            else
                low =  mid;
        }
        if(nums[high]==target)
            res[1] = high;
        return res;
        
    }
}

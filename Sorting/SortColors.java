//Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue. Do not use library's sort function.
public class Solution {
    public void sortColors(int[] nums) {
        int len = nums.length;
        int j=0,k=0,l=0,i=0;
        int zeroIndex = 0;
        int twoIndex = len-1;
        for(i=0;i<len;i++){
            if(i>twoIndex)
                break;
            if(nums[i]==0 && i>=zeroIndex){
                swap(nums,i,zeroIndex);
                zeroIndex++;
                i--;
                continue;
            }
            if(nums[i]==2 && i<=twoIndex){
                swap(nums,i,twoIndex);
                twoIndex--;
                i--;
                continue;
                
            }
        }
    }
    public void swap(int[] nums, int i, int j){
        int a =  nums[i];
        nums[i] =  nums[j];
        nums[j] =  a;
    }
    
}

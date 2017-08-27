//Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
class Solution {
    public int longestConsecutive(int[] nums) {
        int maxLength = 1;
        int length = 1;
        if(nums.length==0){
            return 0;
        }
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],length);
        }
        
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i]-1)){
                int val = nums[i];
                while(map.containsKey(val)){
                    val++;
                }
                if(val-nums[i]>maxLength){
                    maxLength = val-nums[i];
                }
            }
        }
        return maxLength;
    }
}

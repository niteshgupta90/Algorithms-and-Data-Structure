//All unique triplets in the array which gives the sum of zero.
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;){
            int j=i+1;
            int k = nums.length-1;
            while(j<k){
                int val = nums[i]+nums[j]+nums[k];
                if(val==0){
                    LinkedList<Integer> setList = new LinkedList<Integer>();
                    setList.add(nums[i]);
                    setList.add(nums[j]);
                    setList.add(nums[k]);
                    list.add(setList);
                    j++;
                    k--;
                    while(j<k && nums[j]==nums[j-1])
                        j++;
                    while(k>j && nums[k]==nums[k+1])
                        k--;
                }
                else if(val<0){
                    j++;
                    while(j<k && nums[j]==nums[j-1])
                        
                        j++;
                }
                else{
                    k--;
                    while(k>j && nums[k]==nums[k+1])
                        k--;
                }
            }
            i++;
            while(i<nums.length-2 && nums[i]==nums[i-1]){
                i++;
            }
        }
        return list;
    }
}

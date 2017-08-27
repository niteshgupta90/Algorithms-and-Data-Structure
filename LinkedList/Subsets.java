//Given a set of distinct integers, nums, return all possible subsets.
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> arr = new ArrayList<Integer>();
        result.add(arr);
        for(int j=0;j<nums.length;j++){
            int size = result.size();
            for(int i=0;i<size;i++){
                List<Integer> newList = new ArrayList<Integer>(result.get(i));
                newList.add(nums[j]);
                result.add(newList);
            }
        }
        return result;
    }
}

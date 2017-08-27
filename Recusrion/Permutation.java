//Possible Permutations
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> arr = new ArrayList<Integer>();
        int len = nums.length;
        boolean[] isPresent = new boolean[len];
        permute(result,arr,nums,isPresent);
        return result;
    }
    
    public void permute(List<List<Integer>> result, List<Integer> arr, int[] nums, boolean[] isPresent)
    {
        if(arr.size()==nums.length){
            ArrayList<Integer> list = new ArrayList<Integer>(arr);
            result.add(list);
            return ;
        }
        
        for(int i=0;i<nums.length;i++){
            if(isPresent[i]==false){
                arr.add(nums[i]);
                isPresent[i]=true;
                permute(result,arr,nums,isPresent);
                arr.remove(arr.size()-1);
                isPresent[i]=false;
            }
            
        }
        return ;
    }
}

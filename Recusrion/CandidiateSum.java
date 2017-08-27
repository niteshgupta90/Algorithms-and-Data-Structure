//Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> arr = new ArrayList<Integer>();
        result = combinationSum(result,arr,candidates,target,0);
        return result;
    }
    
    public List<List<Integer>> combinationSum(List<List<Integer>> result, List<Integer> arr, int[] candidates, int target, int i)
    {
        if(target==0){
            ArrayList<Integer> list = new ArrayList<Integer>(arr);
            result.add(list);
            return result;
        }
        if(target<0)
            return result;
        
        for(;i<candidates.length;i++){
            arr.add(candidates[i]);
            combinationSum(result,arr,candidates,target-candidates[i],i);
            arr.remove(arr.size()-1);
            
        }
        return result;
    }
}



//Maximum Non Negative Contiguous Subarray
public class Solution {
    public ArrayList<Integer> maxset(ArrayList<Integer> a) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        long maxSum = 0;
        int maxLen= 0;
        
        int size = a.size();
        for(int i=0;i<size;i++){
            long sum = 0;
            int len = 0;
            ArrayList<Integer> temp = new ArrayList<Integer>();
            
            while(i<size && a.get(i)>=0){
                sum+=a.get(i);
                temp.add(a.get(i));
                len++;
                i++;
            }
            if(sum>maxSum || (sum == maxSum && len>maxLen)){
                maxSum = sum;
                maxLen = len;
                result.clear();
                result = temp;
            }
        }
        return result;
        
    }
}

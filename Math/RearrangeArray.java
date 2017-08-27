//Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space.
public class Solution {
    public void arrange(ArrayList<Integer> a) {
        int size = a.size();
        for(int i=0;i<size;i++){
            int val = (a.get(i) + (size*(a.get(a.get(i))%size)));
            a.set(i,val);
        }
        for(int i=0;i<size;i++){
            int val = a.get(i)/size;
            a.set(i,val);
        }	    
    }
}

//Given an unsorted integer array, find the first missing positive integer.
public class Solution {
    public int firstMissingPositive(ArrayList<Integer> a) {
        int _size = a.size();
        ArrayList<Integer> pos = new ArrayList<Integer>();
        pos = getPositiveList(a,_size);
        int size = pos.size();
        int nextIndex = -1;
        int nextVal = -1;
        int i=0;
        for(i=0;i<size;i++){
            if((Math.abs(pos.get(i))-1)<size &&  pos.get(Math.abs(pos.get(i))-1)>0){
                pos.set(Math.abs(pos.get(i))-1,-pos.get(Math.abs(pos.get(i))-1));
            }
        }
        
        for(i=0;i<size;i++){
            if(pos.get(i)>0){
                return i+1;
            }
        }
        return i+1;
    }
    public ArrayList<Integer> getPositiveList(ArrayList<Integer> a,int size){
        ArrayList<Integer> pos = new ArrayList<Integer>();
        for(int i=0;i<size;i++){
            if(a.get(i)>0){
                pos.add(a.get(i));
            }
        }
        return pos;
    }
}

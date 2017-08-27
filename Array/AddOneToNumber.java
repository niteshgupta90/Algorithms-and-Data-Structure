public class Solution {
    public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        int size = a.size();
        int carry = 1;
        int count = 0;
        while(count<size && a.get(count)==0){
            count++;
        }
        if(count==size){
            list.add(1);
            return list;
        }
        for(int i=size-1;i>=count;i--){
            int val = a.get(i)+carry;
            if(val>=10){
                val = val%10;
                carry=1;
            }
            else
                carry = 0;
            list.add(val);
        }
        if(carry==1)
            list.add(carry);
        Collections.reverse(list);
        return list;
    }
}

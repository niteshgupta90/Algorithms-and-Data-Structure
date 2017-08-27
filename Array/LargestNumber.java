//Given a list of non negative integers, arrange them such that they form the largest number.
public class Solution{
    // DO NOT MODIFY THE LIST
    public String largestNumber(final List<Integer> a) {
        List<String> b = new ArrayList<String>();
        
        for(int i=0;i<a.size();i++){
            b.add(String.valueOf(a.get(i)));
        }
        Collections.sort(b,new Comparator<String>() {
            @Override
            public int compare(String a1, String a2) {
                String s1 = a1+a2;
                String s2 = a2+a1;
                
                return s2.compareTo(s1);
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<b.size();i++)
            sb.append(b.get(i));
        String res = sb.toString();
        if(res.charAt(0)=='0')
            return "0";
        return res;
    }
}


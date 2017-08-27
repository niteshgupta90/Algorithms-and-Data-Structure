//Given an array of strings, group anagrams together.
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new  ArrayList<List<String>>();
        List<String> list = new ArrayList<String>();
        String s1 = "";
        String s2 = "";
        Map<String, List<String>> map = new HashMap<String,List<String>>();
        int i = 0;
        while(i<strs.length){
            s1 = sort(strs[i]);
            if(!map.containsKey(s1)){
                List<String> mapList = new ArrayList<String>();
                mapList.add(strs[i]);
                map.put(s1,mapList);
                
            }
            else if(map.containsKey(s1)){
                list = map.get(s1);
                list.add(strs[i]);
                map.put(s1,list);
            }
            i++;
        }
        
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            list = (ArrayList<String>)pair.getValue();
            result.add(list);
        }
        return result;
    }
    String sort(String s){
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        String str = new String(ch);
        return str;
    }
}

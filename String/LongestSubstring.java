//The length of the longest substring without repeating characters
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int size = 0, finalSize = 0, index = 0, i=0;
        for(i=0,index=0;index<s.length();index++){
            
            if(map.containsKey(s.charAt(index))){
                i = Math.max(map.get(s.charAt(index)),i);
            }
            finalSize = Math.max(finalSize, index-i+1);
            map.put(s.charAt(index),index+1);
            
        }
        return finalSize;
    }
}

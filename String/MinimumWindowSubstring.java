//Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
public class Solution {
    public String minWindow(String s, String t) {
        int[] str = new int[256];
        int[] pat = new int[256];
        int len = t.length();
        int len1 = s.length();
        int start = 0;
        int end = 0;
        int charCount = 0;
        int start_index = 0;
        String res = "";
        int minLen = Integer.MAX_VALUE;
        if(len>len1){
            return "";
        }
        int i = 0;
        while(i<len){
            char c = t.charAt(i);
            pat[c]++;
            i++;
        }
        int j = 0;
        
        for(end=0;end<len1;end++){
            char c = s.charAt(end);
            str[c]++;
            if(pat[c]!=0 && str[c]<=pat[c]){
                charCount++;
            }
            if(charCount==len){
                c = s.charAt(start);
                while(start<end && (str[c]>pat[c] || pat[c]==0)){
                    if(str[c]>pat[c]){
                        str[c]--;
                    }
                    start++;
                    c = s.charAt(start);
                }
                if(minLen>end-start+1){
                    minLen = end-start+1;
                    start_index = start;
                }
            }
            if(start_index == -1)
                return "";
        }
        
        return charCount<len?"":s.substring(start_index,minLen+start_index);
    }
}

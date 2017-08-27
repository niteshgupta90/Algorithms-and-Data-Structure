//Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring
public class Solution {
    public int longestValidParentheses(String s) {
        int len = s.length();
        if(len==0||len==1)
            return 0;
        int[] length = new int[len];
        int max = 0;
        length[0] = 0;
        for(int i=1;i<len;i++){
            if(s.charAt(i)==')' && i-length[i-1]-1>=0 && s.charAt(i-length[i-1]-1)=='(' ){
                length[i] = length[i-1] + 2 + (i-length[i-1]-2>=0?length[i-length[i-1]-2]:0);
                max =  Math.max(length[i],max);
            }
        }
        return max;
    }
}

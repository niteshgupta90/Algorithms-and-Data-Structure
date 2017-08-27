//Given a String in zigzag Pattern. Read line by line.
public class Solution {
    public String convert(String s, int numRows) {
        StringBuilder[] str = new StringBuilder[numRows];
        int start = 0;
        int i = 0;
        int len = s.length();
        if(len<numRows || numRows==1)
            return s;
        
        for (i = 0; i < str.length; i++) {
            str[i] = new StringBuilder("");
        }
        i=0;
        while(start<len){
            for(;i<numRows && start<len;i++){
                str[i].append(s.charAt(start));
                start++;
            }
            i= i-2;
            for(;i>=0 && start<len;i--){
                str[i].append(s.charAt(start));
                start++;
            }
            i = i+2;
        }
        for(i=1;i<numRows;i++){
            str[0].append(str[i]);
        }
        return str[0].toString();
    }
}

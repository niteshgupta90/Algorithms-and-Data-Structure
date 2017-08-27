//Implement atoi to convert a string to an integer.
public class Solution {
    public int myAtoi(String str) {
        int len = str.length();
        long res = 0;
        boolean isNegative = false;
        int i = 0;
        if(str=="")
            return 0;
        while(i<len && str.charAt(i) ==' '){
            i++;
        }
        if(i<len && (str.charAt(i)=='+' || str.charAt(i)=='-')){
            if(str.charAt(i)=='-'){
                isNegative = true;
            }
            i++;
        }
        while(i<len && (str.charAt(i)>='0' && str.charAt(i)<='9')){
            res = res*10 + str.charAt(i++) - '0';
            if(res>Integer.MAX_VALUE && isNegative==false)
                return Integer.MAX_VALUE;
            if(-res<(Integer.MIN_VALUE) && isNegative==true)
                return Integer.MIN_VALUE;
        }
        return isNegative==true?-(int)res:(int)res;
    }
}

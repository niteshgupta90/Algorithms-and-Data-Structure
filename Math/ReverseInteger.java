//Reverse a given Integer
public class Solution {
    public int reverse(int x) {
        boolean isNegative=false;
        if(x<10 && x>-9){
            return x;
        }
        if(x<0){
            isNegative = true;
            x = -x;
        }
        
        StringBuilder sb = new StringBuilder(Integer.toString(x));
        try {
            x = Integer.parseInt(sb.reverse().toString());
        }
        catch(NumberFormatException e){
            return 0;
        }
        return isNegative==true?-x:x;
    }
}

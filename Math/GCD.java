//Greatest Common Divisor of two numbers.
public class Solution {
    public int gcd(int a, int b) {
        int max = 0;
        int min = 0;
        
        if(a>b){
            max = a;
            min = b;
        }
        else{
            max =  b;
            min = a;
        }
        if(min==0) return max;
        if(min==1) return 1;
        if(max%min==0) return min;
        
        return gcd(max-min,min);
    }
}

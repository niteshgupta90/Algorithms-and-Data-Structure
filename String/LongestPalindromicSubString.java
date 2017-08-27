//Longest Palindromic SubString of a String s
public class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int maxLength = 1;
        int l=0;
        int len = s.length();
        boolean isPalindrome[][] = new boolean[len][len];
        
        if(s.length()==0){
            return "";
        }
        if(s.length()==1){
            return s;
        }
        //length 1
        for(int i=0;i<len;i++){
            isPalindrome[i][i] = true;
        }
        //length 2
        for(int i=0;i<len-1;i++){
            int j= i+1;
            if(s.charAt(i)==s.charAt(j))
            {
                isPalindrome[i][j]=true;
                start = i;
                maxLength = 2;
            }
            else
                isPalindrome[i][j]=false;
        }
        //length 3 or more
        for(l=3;l<=len;l++){
            for(int i=0;i<len-l+1;i++){
                int j= i+l-1;
                
                if(s.charAt(i)==s.charAt(j) && isPalindrome[i+1][j-1]==true){
                    isPalindrome[i][j]=true;
                    if(l>maxLength)
                    {
                        start = i;
                        maxLength = l;
                    }
                }
                else{
                    isPalindrome[i][j]=false;
                }
                
            }
        }
        String res = new String();
        
        
        return s.substring(start,start+maxLength);
    }
    
}

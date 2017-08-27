//Regular expression matching with support for '.' and '*'.

public class Solution {
    public boolean isMatch(String s, String p) {
        if(p.isEmpty()) return s.isEmpty();
        
        if(p.length()>1 && p.charAt(1)=='*'){
            return isMatch(s, p.substring(2)) || (s.length()>0 &&((s.charAt(0)==p.charAt(0))||(p.charAt(0)=='.')) && isMatch(s.substring(1), p));
        }
        else
            return s.length()>0 && p.length()>0 &&((s.charAt(0)==p.charAt(0))||(p.charAt(0)=='.')) && isMatch(s.substring(1), p.substring(1));
    }
}

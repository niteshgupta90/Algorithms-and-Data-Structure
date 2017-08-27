//generate all combinations of well-formed parentheses.
public class Solution {
    List<String> list = new ArrayList<String>();
    
    public List<String> generateParenthesis(int n) {
        if(n==0)
            return null;
        String str="";
        generateParenthesisUtil(str,2*n,0,n);
        return list;
    }
    public void generateParenthesisUtil(String str, int n, int allowedClose, int remainingOpen){
        if(n==0){
            list.add(str);
            return;
        }
        if(remainingOpen>0)
            generateParenthesisUtil(str+'(',n-1,allowedClose+1,remainingOpen-1);
        if(allowedClose>0){
            generateParenthesisUtil(str+')',n-1,allowedClose-1,remainingOpen);
        }
        return;
    }
}

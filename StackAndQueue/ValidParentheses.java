//Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        int i= 0;
        while(i<s.length()){
            char c = s.charAt(i);
            if(stack.isEmpty() && (c==']' ||c=='}' ||c==')'))
                return false;
            else if(c=='(' ||c=='[' ||c=='{')
                stack.push(c);
            else if((c==')' && stack.peek()=='(') || (c=='}' && stack.peek()=='{') || (c==']' && stack.peek()=='['))
                stack.pop();
            else
                return false;
            i++;
        }
        return stack.isEmpty();
    }
}

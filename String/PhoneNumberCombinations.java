//Given a digit string, return all possible letter combinations that the number could represent.
public class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> keyMap = new HashMap<Character, String>();
        List<String> result = new ArrayList<String>();
        if(digits.isEmpty()){
            return result;
        }
        keyMap.put('1',"");
        keyMap.put('2',"abc");
        keyMap.put('3',"def");
        keyMap.put('4',"ghi");
        keyMap.put('5',"jkl");
        keyMap.put('6',"mno");
        keyMap.put('7',"pqrs");
        keyMap.put('8',"tuv");
        keyMap.put('9',"wxyz");
        keyMap.put('*',"+");
        keyMap.put('0'," ");
        keyMap.put('#',"");
        permRec(digits,0,keyMap,"",result);
        return result;
    }
    
    public void permRec(String digits, int offset, Map<Character, String> keyMap, String sb, List<String> result){
        if(offset>=digits.length()){
            result.add(sb);
            return;
        }
        String str = keyMap.get(digits.charAt(offset));
        for(int i=0;i<str.length();i++){
            permRec(digits, offset+1, keyMap, sb+str.charAt(i), result);
        }
        return;
    }
}

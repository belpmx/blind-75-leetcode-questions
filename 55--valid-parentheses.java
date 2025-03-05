import java.util.HashMap;
import java.util.Stack;

class Solution055 {
    public boolean isValid(String s) {
        HashMap<Character, Character> parenthesesMap = new HashMap<>();
        parenthesesMap.put(')','(');
        parenthesesMap.put(']','[');
        parenthesesMap.put('}','{');
        Stack<Character> inserted = new Stack<>();
        for (int i =0; i<s.length(); i++){
            //found a closing parenthesis ) ] }
            char thisElement = s.charAt(i);
            if (parenthesesMap.containsKey(thisElement)){
                char pop = 'x';
                if (!inserted.isEmpty()){
                    pop = inserted.pop();
                }
                //need to validate what we have on top is the same opening parenthesis
                //get the value for the matched key
                if (pop != parenthesesMap.get(thisElement)){
                    return false;
                }
            } else {
                inserted.push(thisElement);
            }
        }
        //check is the stack is empty
        return inserted.isEmpty();
    }
}




















class Solution55 {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (map.containsKey(curr)) {
                char pop = stack.size() != 0 ? stack.pop() : '#';
                if (pop != map.get(curr)) {
                    return false;
                }
            } else {
                stack.push(curr);
            }
        }
        return stack.isEmpty();
    }
}

// TC: O(n), SC: O(n)

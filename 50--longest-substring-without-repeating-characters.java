import java.util.HashMap;
class Solution050 {
    public int lengthOfLongestSubstring(String s) {
        int result =0;
        HashMap<Character, Integer> mapValues = new HashMap<>();
        //index of the pointer to iterate the String
        int left =0;
        int right =0;
        for (right =0; right < s.length();right++){
           char thisChar = s.charAt(right);
           //store the value if not yet inserted
           if(!mapValues.containsKey(thisChar)){
               mapValues.put(thisChar,right);
           } else{
               // shift the left since a duplicated character appear
               //special case for abba scenarios
               left = Math.max(left, mapValues.get(thisChar)+1);
               //update the occurrence
               mapValues.put(thisChar,right);
           }
           //determine if this new lenght is greater than previous
            result = Math.max(result, right -left +1);
        }
     return result;
    }
}





















class Solution50 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int ans = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (!map.containsKey(ch)) {
                map.put(ch, right);
            } else {
                left = Math.max(left, map.get(ch) + 1);
                map.put(ch, right);
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
} // TC: O(n), SC: O(n)

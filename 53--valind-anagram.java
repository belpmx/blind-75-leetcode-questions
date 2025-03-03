import java.util.HashMap;
import java.util.Map;

class Solution053 {
    //non working, need to troubleshoot
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        HashMap<String, Integer> mapS = new HashMap<>();
        HashMap<String, Integer> mapT = new HashMap<>();
        for (int i = 0; i<s.length();i++){
            //Store both strings into Hash map
            //Key is the char, value is the count of occurrences of the char
            if (mapS.containsKey(s.charAt(i))){
                int value = mapS.get(s.charAt(i)) +1;
                mapS.replace(String.valueOf((s.charAt(i))),value);
            } else {
                mapS.put(String.valueOf((s.charAt(i))),1);
            }

            if (mapT.containsKey(t.charAt(i))){
                int value = mapT.get(t.charAt(i)) +1;
                mapT.replace(String.valueOf((t.charAt(i))),value);
            } else {
                mapT.put(String.valueOf((t.charAt(i))),1);
            }
        }

        for (Map.Entry<String,Integer> entry :mapS.entrySet()){
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (mapT.containsKey(key)){
              if (mapT.get(key) != value){
                  return false;
              }
            } else {
                return false;
            }
        }
        return true;
    }
}

class Solution0053 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        //Create an array to hold each of the characters of ascii chars
        int[] mapChars = new int [26];
        //For s iterate and increment by one for each occurrence
        //For t iterate and decrement by one for each occurrence
        for (int i = 0; i<s.length(); i++){
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            mapChars[charS - 'a']++;
            mapChars[charT - 'a']--;
        }
        //Scan array and all elements must be zero
        for(int i =0; i< mapChars.length;i++){
            if(mapChars[i]!=0){
                return false;
            }
        }
        return true;
    }
}



















class Solution53 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            map[c1 - 'a']++;
            map[c2 - 'a']--;
        }
        for (int i = 0; i < map.length; i++) {
            if (map[i] != 0) {
                return false;
            }
        }
        return true;
    }
} // TC: O(n), SC: O(1)F

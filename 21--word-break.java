import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solutio021{
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean [] matches = new boolean[s.length() +1];
        //true is inserted when a word occurrence is found, first extra element is base scenario
        matches[0] = true;
        //hashset to store the wordD Dict, no need to store duplicated words
        Set<String> set = new HashSet<>(wordDict);
        for (int i =1; i<= s.length();i++){
            //contidion is <= to include substring range
            for (int j=0; j<i; j++){
                // create substring from zero increasing and compare against words on dictionary
                String subString = s.substring(j,i);
                if (set.contains(subString)){
                   //if word is found then validate  the index of the matches
                   if(matches[j] == true){
                       //update at i that the word is found
                       matches[i] = true;
                       break;
                   }
                }
            } //end for j
        }//end for i
        return matches[s.length()];
    }
}



















class Solution21 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        Set<String> set = new HashSet<>(wordDict);
        for (int i = 1; i <= s.length(); i++) { // n
            for (int j = 0; j < i; j++) { // n
                String suffix = s.substring(j, i); // n
                if (set.contains(suffix) && dp[j] == true) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}

// TC: O(n^3 + m), SC: O(n + m)

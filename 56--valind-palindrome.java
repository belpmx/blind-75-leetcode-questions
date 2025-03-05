class Solution056 {
    public boolean isPalindrome(String s) {
      int left = 0;
      int right = s.length()-1;
      while (left <= right){
          char c1 = s.charAt(left);
          char c2 = s.charAt(right);
          if (!Character.isLetterOrDigit(c1)){
              left ++;
          }
          else if (!Character.isLetterOrDigit(c2)){
              right --;
          } else {
              if  (Character.toLowerCase(c1)!= Character.toLowerCase(c2)){
                  return false;
              }
              left ++;
              right --;
          }
      }
      return true;
    }
}













class Solution56 {
    public boolean isPalindrome(String s) {
        int p1 = 0, p2 = s.length() - 1;
        while (p1 <= p2) {
            char c1 = s.charAt(p1);
            char c2 = s.charAt(p2);
            if (Character.isLetterOrDigit(c1) == false) p1++;
            else if (Character.isLetterOrDigit(c2) == false) p2--;
            else {
                if (Character.toLowerCase(c1) != Character.toLowerCase(c2)) {
                    return false;
                }
                p1++;
                p2--;
            }
        }
        return true;
    }
} // TC: O(n), SC: O(1)

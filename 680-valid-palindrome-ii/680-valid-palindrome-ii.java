class Solution {
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        
        while(i < j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }
            else{
                return isPal(s.substring(i + 1, j + 1)) || isPal(s.substring(i, j));
            }
        }
        return true;
    }
    
    public boolean isPal(String s){
        int i = 0;
        int j = s.length() -  1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
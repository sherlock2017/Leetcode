class Solution {
    public boolean isAnagram(String s, String t) {
        if(t.length() < s.length() || t.length() > s.length()){
            return false;
        }
        
        int[] src = new int[26];
        
        for(char c : s.toCharArray()){
            src[c - 'a']++;
        }
        
        for(char c : t.toCharArray()){
            if(src[c - 'a'] > 0){
                src[c - 'a']--;
            }
            else{
                return false;
            }
        }
        
        return true;
    }
}
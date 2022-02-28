class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> indexes = new ArrayList<>();
        
        for(int i = 0; i <= s.length() - p.length(); i++){
            String str = s.substring(i, i + p.length());
            if(isAnagram(str, p)){
                indexes.add(i);
            }
        }
        
        return indexes;
    }
    
    public boolean isAnagram(String s, String t){
        int[] src = new int[26];
        for(char ch : s.toCharArray()){
            src[ch - 'a']++;
        }
        
        for(char ch : t.toCharArray()){
            if(src[ch - 'a'] > 0){
                src[ch - 'a']--;
            }
            else{
                return false;
            }
        }
        
        return true;
    }
}
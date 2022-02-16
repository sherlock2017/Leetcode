class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return s.length();
        int maxLen = Integer.MIN_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
        int i = -1;
        int j = -1;
        
        while(true){
            boolean f1 = false;
            boolean f2 = false;
            //acquire the character
            while(i < s.length() - 1){
                f1 = true;
                i++;
                char ch = s.charAt(i);
                
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                
                if(map.get(ch) == 2){
                    // invalid state
                    break;
                }
                else{
                    int len = i - j;
                    if(len > maxLen){
                        maxLen = len;
                    }
                }
            }
            
            while(j < i){
                f2 = true;
                j++;
                char ch = s.charAt(j);
                
                map.put(ch, map.get(ch) - 1);
                
                if(map.get(ch) == 1){
                    // valid state
                    break;
                }
            }
            
            if(f1 == false && f2 == false){
                break;
            }
        }
        
        return maxLen;
    }
}
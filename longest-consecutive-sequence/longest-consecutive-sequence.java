class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        
        for(int val : nums){
            map.put(val, true);
        }
        
        for(int val : nums){
            if(map.containsKey(val - 1)){
                map.put(val, false);
            }
        }
        
        int maxlen = 0;
        for(int val : nums){
            if(map.get(val) == true){
                int ilen = 1;
                
                while(map.containsKey(val + ilen)){
                    ilen++;
                }
                
                if(ilen > maxlen){
                    maxlen = ilen;
                }
            }
        }
        
        return maxlen;
    }
}
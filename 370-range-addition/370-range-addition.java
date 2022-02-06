class Solution {
    
    // revisit 
    public int[] getModifiedArray(int length, int[][] updates) {
        
        int[] res = new int[length];
        
        // create impact with each update query
        for(int i = 0; i < updates.length; i++){
            int starti = updates[i][0];
            int endi = updates[i][1];
            int inc = updates[i][2];
            
            res[starti] += inc;
            if(endi + 1 < length){
                res[endi + 1] -= inc;
            }
        }
        
        // calculate prefix sum
        int sum = 0;
        for(int i = 0; i < length; i++){
            sum += res[i];
            res[i] = sum;
        }
        
        return res;
    }
}
class Solution {
    public int maxSubArray(int[] nums) {
        int cb = nums[0];
        int ob = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            if(cb + nums[i] < nums[i]){
                cb = nums[i];
            }
            else{
                cb += nums[i];
            }
            
            if(cb > ob){
                ob = cb;
            }
        }
        
        return ob;
    }
}
class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int i = 0;
        int j = nums.length - 1;
        int idx = nums.length - 1;
        
        while(i < j){
            int isq = nums[i] * nums[i];
            int jsq = nums[j] * nums[j];
            
            if(isq > jsq){
                res[idx] = isq;
                i++;
                idx--;
            }
            else{
                res[idx] = jsq;
                j--;
                idx--;
            }
        }
        
        res[idx] = nums[i] * nums[j];
        return res;
    }
}
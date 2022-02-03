class Solution {
    int ways = 0;
    public int findTargetSumWays(int[] nums, int target) {
        helper(nums, 0, 0, target);
        return ways;
    }
    
    public void helper(int[] nums, int idx, int ssf, int target){
        if(idx == nums.length){
            if(ssf  == target){
                ways++;
            }
            return;
        }
        
        helper(nums, idx + 1, ssf + nums[idx], target);
        helper(nums, idx + 1, ssf - nums[idx], target);
    }
}
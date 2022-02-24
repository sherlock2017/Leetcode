class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        int lo = 0;
        int hi = nums.length - 1;
        
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            
            if(nums[mid] == target){
                res[0] = mid;
                hi = mid - 1;
            }
            else if(nums[mid] > target){
                hi = mid - 1;
            }
            else{
                lo = mid + 1;
            }
        }
        
         lo = 0;
         hi = nums.length - 1;
        
         while(lo <= hi){
            int mid = (lo + hi) / 2;
            
            if(nums[mid] == target){
                res[1] = mid;
                lo = mid + 1;
            }
            else if(nums[mid] > target){
                hi = mid - 1;
            }
            else{
                lo = mid + 1;
            }
        }

        return res;
    }
}
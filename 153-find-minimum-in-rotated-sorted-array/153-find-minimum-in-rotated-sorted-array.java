class Solution {
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            
            if(nums[lo] <= nums[hi]){
                // arrray is not rotated at all
                return nums[lo];
            }
            else if(nums[mid] > nums[mid + 1]){
                // if the right element of current element is small then right element is the minium of the array
                return nums[mid + 1];
            }
            else if(nums[mid] < nums[mid - 1]){
                // if the left element of current element is greater then current element is the minimum of the array
                return nums[mid];
            }
            else if(nums[lo] <= nums[mid]){
                // means lo to mid is already sorted
                lo = mid + 1;
            }
            else if(nums[hi] >= nums[mid]){
                // means mid to hi is already sorted
                hi = mid - 1;
            }
        }
        
        return -1;
    }
}
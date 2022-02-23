class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] merged = new int[m + n];
        
        int i = 0;
        int j = 0;
        int idx = 0;
    
        while(i < m && j < n){
            if(nums1[i] > nums2[j]){
                merged[idx] = nums2[j];
                idx++;
                j++;
            }
            else {
                merged[idx] = nums1[i];
                idx++;
                i++;
            }
        }
        
        while(i < m){
            merged[idx] = nums1[i];
            idx++;
            i++;
        }
        
        while(j < n){
            merged[idx] = nums2[j];
            idx++;
            j++;
        }

        double median = 0d;
        if(merged.length % 2 == 0){
            // even length  
            int mid = merged.length / 2;
            median = (merged[mid - 1] + merged[mid]) / 2d;
        }
        else{
            median = merged[merged.length / 2];
        }
        
        return median;
    }
}
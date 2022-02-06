class Solution {
    public int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        int i = 0;
        int j = height.length - 1;
        
        // O(n) solution
        while(i < j){
            int h = Math.min(height[i], height[j]);
            int w = j - i;
            int area =  h * w;
            
            if(height[i] < height[j]){
                i++;
            }
            else{
                j--;
            }
            
            if(area > maxArea){
                maxArea = area;
            }
        }
        
        return maxArea;
    }
}
class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int[] rb = new int[heights.length];
        Stack<Integer> rs = new Stack<>();
        rs.push(heights.length - 1);
        rb[heights.length - 1] = heights.length;
        for(int i = heights.length - 2; i >= 0; i--){
            while(rs.size() > 0 && heights[i] <= heights[rs.peek()] ){
                rs.pop();
            }
            
            if(rs.size() == 0){
                rb[i] = heights.length;
            }
            else{
                rb[i] = rs.peek();
            }
            rs.push(i);
        }
        
        
        int[] lb = new int[heights.length];
        Stack<Integer> ls = new Stack<>();
        ls.push(0);
        lb[0] = -1;
        for(int i = 1; i < heights.length; i++){
            while(ls.size() > 0 && heights[i] <= heights[ls.peek()]) {
                ls.pop();
            }    
            
            if(ls.size() == 0){
                lb[i] = -1;
            }
            else{
                lb[i] = ls.peek();
            }
            
            ls.push(i);
        }
        
        
        int maxArea = 0;
        for(int i = 0; i < heights.length; i++){
            int width = rb[i] - lb[i] - 1;
            int height = heights[i];
            int area = width * height;
            if(area > maxArea){
                maxArea = area;
            }
        }
        
        return maxArea;
    }
}
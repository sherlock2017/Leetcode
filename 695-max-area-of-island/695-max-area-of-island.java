class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
        int maxArea = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    int area = bfs(grid, i, j);
                    
                    if(area > maxArea){
                        maxArea = area;
                    }
                }
            }
        }
        
        return maxArea;
    }
    
    class Point {
        int i;
        int j;
        
        Point(int i , int j){
            this.i = i;
            this.j = j;
        }
    }

    public int bfs(int[][] grid, int i, int j){
        
        ArrayDeque<Point> queue = new ArrayDeque<>();
        queue.add(new Point(i,j));
        int n = grid.length;
        int m = grid[0].length;
        
        int area = 0;
        
        // rm*wa*
        while(queue.size() > 0){
            Point rem = queue.remove();
            
            if(rem.i < 0 || rem.i >= n || rem.j < 0 || rem.j >= m || grid[rem.i][rem.j] == 0){
                continue;
            }
            
            grid[rem.i][rem.j] = 0;
            area++;
        
            queue.add(new Point(rem.i - 1, rem.j));
            queue.add(new Point(rem.i, rem.j + 1));
            queue.add(new Point(rem.i + 1, rem.j));
            queue.add(new Point(rem.i, rem.j - 1));
        }
        
        return area;
    }
}
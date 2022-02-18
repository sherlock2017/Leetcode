class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        dfs(grid, row, col, grid[row][col]);
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] < 0){
                    grid[i][j] = color;
                }
            }
        }
        
        return grid;
    }
    
    int[][] dirs = {{0,1}, {1, 0}, {0, -1}, {-1, 0}};
    public void dfs(int[][] grid, int row, int col, int clr){
        grid[row][col] = -clr;
        int count = 0;
        
        for(int i = 0; i < 4; i++){
            int _row = row + dirs[i][0];
            int _col = col + dirs[i][1];
            
            if(_row < 0 || _col < 0 || _row >= grid.length || 
              _col >= grid[0].length || Math.abs(grid[_row][_col]) !=  clr){
                continue;
            }
            count++;
            
            if(grid[_row][_col] == clr){
                dfs(grid, _row, _col, clr);   
            }
        }
        
        if(count == 4){
            grid[row][col] = clr;
        }
    }
}
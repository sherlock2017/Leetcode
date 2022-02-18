class Solution {
    
    StringBuilder hash = new StringBuilder();
    public int numDistinctIslands(int[][] grid) {
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    hash = new StringBuilder();
                    hash.append("x");
                    dfs(grid, i, j, hash);
                    set.add(hash.toString());
                }
            }
        }
        System.out.println(set);
        return set.size();
    }
    
    
    public void dfs(int[][] grid, int i , int j, StringBuilder hash){
        
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0){   
            hash.append("R");
            return;
        }
        
        grid[i][j] = 0;
        dfs(grid, i - 1, j, hash.append("N"));
        dfs(grid, i, j + 1, hash.append("E"));
        dfs(grid, i + 1, j, hash.append("S"));
        dfs(grid, i, j - 1, hash.append("W"));
    }
}
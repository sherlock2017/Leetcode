class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] != newColor)dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    
    public void dfs(int[][] image, int i, int j, int curr, int  newColor){
        if(i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] != curr){
            return;
        }
        
        if(image[i][j] == curr){
            image[i][j] = newColor; 
            dfs(image, i - 1, j, curr, newColor);
            dfs(image, i, j + 1, curr, newColor);
            dfs(image, i + 1, j, curr, newColor);
            dfs(image, i, j - 1, curr, newColor);
        }

    }
}
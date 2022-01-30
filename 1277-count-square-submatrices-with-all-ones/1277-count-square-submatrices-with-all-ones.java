class Solution {
    public int countSquares(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i = matrix.length - 1; i >= 0; i--){
            for(int j = matrix[0].length - 1; j >= 0; j--){
                if(matrix[i][j] != 0){
                    if(i == matrix.length - 1 || j == matrix[0].length - 1){
                        dp[i][j] = 1;
                    }
                    else{
                        dp[i][j] = Math.min(Math.min(dp[i][j + 1], dp[i + 1][j + 1]), dp[i + 1][j]) + 1;
                    }
                }
            }
        }
        
        // count the total squares of n-sides
        int count = 0;
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                count += dp[i][j];
            }
        }
        
        return count;
    }
}
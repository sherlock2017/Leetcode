class Solution {
    public int maximalSquare(char[][] matrix) {
        int maxSquareLen = findMaxLen(matrix);
        return maxSquareLen * maxSquareLen;
    }

    public int findMaxLen(char[][] matrix){
        int maxLen = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i = dp.length - 1; i >= 0; i--){
            for(int j = dp[0].length - 1; j >= 0; j--){
                if(matrix[i][j] != '0'){
                    if(i == dp.length - 1 || j == dp[0].length - 1){
                        dp[i][j] = 1;
                    }
                    else{
                        dp[i][j] = 1 + Math.min(dp[i][j + 1], Math.min(dp[i + 1][j + 1], dp[i + 1][j]));
                    }
                }
                
                if(dp[i][j] > maxLen){
                    maxLen = dp[i][j];
                }
            }
        }
        
        return maxLen;
    }
}
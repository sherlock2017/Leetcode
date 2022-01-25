class Solution {
    public String longestPalindrome(String s) { 
        int longPalLen = 0;
        int idx = 0;
        int x = 0;
        int y = 0;
        // same as previous category to find the count of longest substring palindrome
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int gap = 0; gap < dp.length; gap++){
            for(int i = 0, j = gap; j < dp.length; i++, j++){
                if(gap == 0){
                    dp[i][j] = true;
                }
                else if(gap == 1){
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = true;
                    }
                    else{
                        dp[i][j] = false;
                    }
                }
                else{
                    if(s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == true){
                        dp[i][j] = true;
                    }
                    else{
                        dp[i][j] = false;
                    }
                }
                
                if(dp[i][j]){
                    longPalLen = gap + 1;
                    x = i;
                    y = j;
                }
            }
        }
        return s.substring(x, y + 1);
    }
}
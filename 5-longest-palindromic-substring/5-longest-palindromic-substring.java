class Solution {
    public String longestPalindrome(String s) { 
        int x = 0;
        int y = 0;
        // same as previous category to find the count of longest substring palindrome
        // note: dp kaa matlab:
        // dp x axis = end points
        // dp y axis = start points
        // sare gap diagonals pr check kro ki palindrome hai ki nahi
        // gap = 0 diagonal - ye toh palindrome honge hi, since start aur end same hai 
        // gap = 1 diagonal - ye tabhi palindrome honge jab start aur end character same honge
        // gap > 1 diagonal - ye tabhi palindrom honge jab :
                                // 1) start aur end character same honge aur 
                                // 2) beech ki puri string palindrome ho - i + 1, j - 1 pr ho calculate kia tha vo
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
                    x = i;
                    y = j;
                }
            }
        }
        return s.substring(x, y + 1);
    }
}
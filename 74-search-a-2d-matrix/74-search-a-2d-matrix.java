class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = binarySearchForRow(matrix, target);
        if(row == -1) return false;
        return binarySearchForTarget(matrix, row, target);
    }
    
    public int binarySearchForRow(int[][] matrix, int target){
        int lo = 0; 
        int hi = matrix.length - 1;
        int chi = matrix[0].length - 1;
        
        while(lo <= hi && lo < matrix.length && hi >= 0){
            int mid = (lo + hi) / 2;
            
            if(matrix[mid][0] <= target && target <= matrix[mid][chi]){
                return mid;
            }
            else if(matrix[mid][0] < target){
                lo = mid + 1;
            }
            else{
                hi = mid - 1;
            }
        }
        return -1;
    }
    
    public boolean binarySearchForTarget(int[][] matrix, int row, int target){
        int lo = 0;
        int hi = matrix[row].length - 1;
        
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            
            if(matrix[row][mid] == target){
                return true;
            }
            else if(matrix[row][mid] < target){
                lo = mid + 1;
            }
            else{
                hi = mid - 1;
            }
        }
        
        return false;
    }
}
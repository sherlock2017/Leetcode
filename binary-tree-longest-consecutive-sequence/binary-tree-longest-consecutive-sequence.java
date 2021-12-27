/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int longestConsecutive(TreeNode root) {
        return dfs_lc(root, root, 1);
    }
    
    public int dfs_lc(TreeNode node, TreeNode parent, int length){
        
        if(node == null){
            return 0;
        }
        
        length = parent.val == node.val - 1 ? length + 1 : 1;
        int lc = dfs_lc(node.left, node, length);
        int rc = dfs_lc(node.right, node, length);
        
        length = Math.max(length, Math.max(lc, rc));
        return length;        
    }
    
    
}
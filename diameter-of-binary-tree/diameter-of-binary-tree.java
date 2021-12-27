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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        int ld = diameterOfBinaryTree(root.left);
        int rd = diameterOfBinaryTree(root.right);
        
        int f = height(root.left) + height(root.right) + 2;
        
        int myd = Math.max(f, Math.max(ld, rd));
        return myd;
    }
    
    public int height(TreeNode node){
        if(node == null){
            return -1;
        }
        
        int lh = height(node.left);
        int rh = height(node.right);
        
        int mh = 1 + Math.max(lh, rh);
        return mh;
    }
}
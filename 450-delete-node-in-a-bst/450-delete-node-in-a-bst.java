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
    
    
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        
        if(key > root.val){
            root.right = deleteNode(root.right, key);
        }
        else if(key < root.val){
            root.left = deleteNode(root.left, key);
        }
        else{
            if(root.left != null && root.right != null){
                // has both childs
                // find the max in the left subtree
                // replace it with the c
                TreeNode max = findMax(root.left);
                root.val = max.val;
                root.left = deleteNode(root.left, max.val);
            }
            else if(root.left != null){
                // has only left child
                return root.left;
            }
            else if(root.right != null){
                // has  only right child
                return root.right;
            }
            else{
                // has not child
                return null;
            }
        }
        
        return root;
    }
    
    public TreeNode findMax(TreeNode node){
        if(node.right == null){
            return node;
        }
        return findMax(node.right);
    }
}
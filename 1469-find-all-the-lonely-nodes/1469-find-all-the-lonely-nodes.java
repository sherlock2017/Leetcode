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
    public List<Integer> getLonelyNodes(TreeNode root) {
        ArrayList<Integer> lonelyNodes = new ArrayList<>();
        dfs(root, lonelyNodes, false);
        return lonelyNodes;
    }
    
    public void dfs(TreeNode node, ArrayList<Integer> lonelyNodes, boolean isLonely){
        if(node == null){
            return;
        }
        
        if(isLonely){
            lonelyNodes.add(node.val);
        }
        
        dfs(node.left, lonelyNodes, node.right == null);
        dfs(node.right, lonelyNodes, node.left == null);
    }
}
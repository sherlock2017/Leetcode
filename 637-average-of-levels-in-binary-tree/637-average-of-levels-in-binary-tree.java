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
    public List<Double> averageOfLevels(TreeNode root) {
        // using BFS
        
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        
        List<Double> averages = new ArrayList<>();
        
        while(queue.size() > 0){
            int unprocessedNodes = queue.size();
            
            double sumOfNumbers = 0d;
            int totalNumbers = 0;
            while(unprocessedNodes > 0){
                unprocessedNodes--;
                TreeNode rem = queue.remove();
                
                sumOfNumbers += rem.val;
                totalNumbers++;
                
                if(rem.left != null){
                    queue.add(rem.left);
                }
                
                if(rem.right != null){
                    queue.add(rem.right);
                }
            }
            
            averages.add(sumOfNumbers / totalNumbers);
        }
        
        return averages;
    }
}
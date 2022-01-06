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
    
    class Pair{
        TreeNode node;
        int level;
        
        Pair(TreeNode node, int level){
            this.node = node;
            this.level = level;
        }
    }
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> master = new ArrayList<>();        
        Stack<TreeNode> ms = new Stack<>();
        Stack<TreeNode> cs = new Stack<>();
        ms.add(root);
        int level = 1;
        
        ArrayList<Integer> list = new ArrayList<>();
        while(ms.size() > 0){

            TreeNode node = ms.pop();
            
            if(node != null){
                list.add(node.val);
                if(level % 2 == 0){
                    cs.push(node.right);
                    cs.push(node.left);
                }
                else{
                    cs.push(node.left);
                    cs.push(node.right);
                }

            }
          
            
            if(ms.size() == 0){
                ms = cs;
                cs = new Stack<>();
                if(list.size() > 0){
                   master.add(list); 
                }
                list = new ArrayList<>();
                level++;
            }
        }
        
        return master; 
    }
}
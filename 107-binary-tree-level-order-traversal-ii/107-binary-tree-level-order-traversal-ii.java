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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        
        Stack<List<Integer>> st = new Stack<>();
        while(queue.size() > 0){
            int unprocessedNodes = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            while(unprocessedNodes > 0){
                unprocessedNodes--;
                TreeNode rem = queue.remove();
                
                list.add(rem.val);
                
                if(rem.left != null){
                    queue.add(rem.left);
                }
                
                if(rem.right != null){
                    queue.add(rem.right);
                }
            }
            st.add(list);
        }
        
        List<List<Integer>> result = new ArrayList<>();
        while(st.size() > 0){
            result.add(st.pop());
        }
        
        return result;
    }
}
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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        ArrayList<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> q = new LinkedList<>();
        q.addFirst(root);
        while(q.size() != 0){
            int size = q.size();
            res.add(q.getFirst().val);
            while(size-- > 0){
                TreeNode node = q.removeFirst();
                if(node.right != null) q.addLast(node.right);
                if(node.left != null) q.addLast(node.left);
            }
        }
        return res;
    }
}
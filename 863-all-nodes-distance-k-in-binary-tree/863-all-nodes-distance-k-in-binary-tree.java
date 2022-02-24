/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        findPath(root, target.val); 
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < path.size() && i <= k; i++){
            ArrayList<Integer> list = new ArrayList<>();
            findKLevelsDown(path.get(i), k - i, list, i == 0 ? null : path.get(i - 1));
            result.addAll(list);
        }
        return result;
    }
    
    public void findKLevelsDown(TreeNode node, int k, ArrayList<Integer> list, TreeNode blocker){
        
        if(node == null || k < 0 || node == blocker){
            return;
        }
        
        if(k == 0){
            list.add(node.val);
        }
        
        findKLevelsDown(node.left, k - 1, list, blocker);
        findKLevelsDown(node.right, k - 1, list, blocker);
    }
    
    ArrayList<TreeNode> path = new ArrayList<>();
    public boolean findPath(TreeNode node, int target){
        
        if(node == null){
            return false;
        }
        
        if(node.val == target){
            path.add(node);
            return true;
        }
        
        boolean fil = findPath(node.left, target);
        if(fil){
            path.add(node);
            return true;
        }
        
        boolean fir = findPath(node.right, target);
        if(fir){
            path.add(node);
            return true;
        }
        
        return false;
    }
    
    
}
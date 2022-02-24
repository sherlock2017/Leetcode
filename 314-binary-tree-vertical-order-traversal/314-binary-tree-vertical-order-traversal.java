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
    
    class NodeOrder {
        TreeNode node;
        int order;
        
        NodeOrder(TreeNode node, int order){
            this.node = node;
            this.order = order;
        }
    }
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        // bfs
        ArrayDeque<NodeOrder> queue = new ArrayDeque<>();
        queue.add(new NodeOrder(root, 0));
        
        int minc = Integer.MAX_VALUE;
        int maxc = Integer.MIN_VALUE;
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        while(queue.size() > 0){
            int unprocessedNode = queue.size();
            
            while(unprocessedNode > 0){
              unprocessedNode--;   
              NodeOrder rem = queue.remove();
             
              map.putIfAbsent(rem.order, new ArrayList<>());
              map.get(rem.order).add(rem.node.val);
          
              if(rem.node.left != null){
                  queue.add(new NodeOrder(rem.node.left, rem.order - 1));
              }
            
              if(rem.node.right != null){
                  queue.add(new NodeOrder(rem.node.right, rem.order + 1));
              }
                
              if(rem.order < minc){
                  minc = rem.order;
              }
                
              if(rem.order > maxc){
                  maxc = rem.order;
              }
            }
        }
        
        System.out.println(map);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = minc; i <= maxc; i++){
            result.add(map.get(i));
        }
        
        return result;
    }
}
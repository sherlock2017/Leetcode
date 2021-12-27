/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    class Pair implements Comparable<Pair> {
        int ai;
        int val;
        ListNode next;
        
        Pair(int ai, int val, ListNode next){
            this.ai = ai;
            this.val = val;
            this.next = next;
        }
        
        public int compareTo(Pair o){
            return this.val - o.val;
        }
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        for(int i = 0; i < lists.length; i++){
            if(lists[i] != null){
               pq.add(new Pair(i, lists[i].val, lists[i].next));
            }
        }
        
        ListNode head = null;
        while(pq.size() > 0){
            Pair pair = pq.remove();
            
            // create a new node from pair val and it
            if(head == null){
                head = new ListNode(pair.val);
            }
            else{
                ListNode temp = head;
                while(temp.next != null){
                    temp = temp.next;
                }
                temp.next = new ListNode(pair.val); 
            }
            
            if(pair.next != null){
                pair.val = pair.next.val;
                pair.next = pair.next.next;
                pq.add(pair);
            }
        }
        
        return head;
    }
}
class Solution {
    
    class Pair implements Comparable<Pair> {
        int num;
        int freq;
        
        Pair(int num, int freq){
            this.num = num;
            this.freq = freq;
        }
        
        public int compareTo(Pair o){
            return this.freq -  o.freq;
        }
    }
    
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            else{
                map.put(nums[i], 1);
            }
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int key : map.keySet()){
            if(pq.size() < k){
                pq.add(new Pair(key, map.get(key)));
            }
            else{
                int cf = map.get(key);
                if(cf > pq.peek().freq){
                    pq.remove();
                    pq.add(new Pair(key, cf));
                }
            }
        }
        
        int[] res = new int[pq.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = pq.remove().num;
        }
        
        return res;
    }
}
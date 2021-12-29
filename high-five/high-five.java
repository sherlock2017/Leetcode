class Solution {
    

    public int[][] highFive(int[][] items) {
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < items.length; i++){
            int sid = items[i][0], score = items[i][1];
            
            if(map.containsKey(sid)){
                map.get(sid).add(score);
            }
            else{
                ArrayList<Integer> scores = new ArrayList<>();
                scores.add(score);
                map.put(sid, scores);
            }
        }   
        
        int[][] res = new int[map.keySet().size()][2];
        int idx = 0;
        for(int sid: map.keySet()){
            ArrayList<Integer> scores = map.get(sid);
            Collections.sort(scores);
            
            int sc = 0;
            int total = 0;
            for(int i = scores.size() - 1, top = 0; i >= 0 && top < 5; i--, top++){
                total+=scores.get(i);
            }
            
            int avg = total / 5;
            res[idx][0] = sid;
            res[idx][1] = avg;
            idx++;
        }
        
        return res;
    }
}
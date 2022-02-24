class Solution {

    int[][] dirs = {{-1,0}, {0, 1}, {1, 0}, {0, -1}};
    public int maximumMinimumPath(int[][] grid) {
       // using dijkstra's flavor of BFS
       PriorityQueue<Pair> pq = new PriorityQueue<>();
       boolean[][] visited = new boolean[grid.length][grid[0].length];
       pq.add(new Pair(0, 0, grid[0][0]));
      
       int di = grid.length - 1;
       int dj = grid[0].length - 1;
        
       int min = Integer.MAX_VALUE;
        
       // rm*wa*
       while(pq.size() > 0){
           Pair rem = pq.remove();
           
           if(visited[rem.i][rem.j] == true){
               continue;
           }
           visited[rem.i][rem.j] = true;
           
           if(grid[rem.i][rem.j] < min){
               min = grid[rem.i][rem.j];
           }
           
           if(rem.i == di && rem.j == dj){
               break;
           }
           
           for(int k = 0; k < 4; k++){
               int ni = rem.i + dirs[k][0];
               int nj = rem.j + dirs[k][1];
               
               if(ni >= 0 && ni < grid.length && nj >= 0 && nj < grid[0].length){
                   pq.add(new Pair(ni, nj, grid[ni][nj]));
               }
           }
       }
        
       return min;
    }

    
    class Pair implements Comparable<Pair> {
        
        int i;
        int j;
        int val;
        
        Pair(int i, int j, int val){
            this.i = i;
            this.j = j;
            this.val = val;
        }
        
        public int compareTo(Pair o){
            return o.val - this.val;
        }
    }
    
}
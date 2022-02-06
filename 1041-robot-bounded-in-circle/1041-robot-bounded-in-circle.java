class Solution {
    public boolean isRobotBounded(String instructions) {
        int sx = 0;
        int sy = 0;
        int dir = 0; 
        
        int cx = sx;
        int cy = sy;
        
        System.out.println("cx = "+cx+", cy = "+cy);
        for(int i = 0; i < instructions.length(); i++){
            char ins = instructions.charAt(i);
            if(ins == 'G'){
                // move ahead in the current direction;
                if(dir == 0){
                    // move towards north
                    cy++;
                }
                else if(dir == 1){
                    // move towards east
                    cx++;
                    cy++;
                }
                else if(dir == 2){
                    // move towards south
                    cy--;
                }
                else if(dir == 3){
                    // move towards west
                    cx--;
                    cy--;
                }
                System.out.println("cx = "+cx+", cy = "+cy);
            }
            else{
                System.out.print("direction changed from "+dir);
                // change direction
                if(ins == 'L'){
                    // face anticlock-wise
                    dir = dir + 3;
                    dir = Math.abs(dir % 4);
                }
                else if(ins == 'R'){
                    // face clock-wise
                    dir++;
                     dir = Math.abs(dir % 4);
                }
                 System.out.print(" to "+dir+"\n");
            }

        }
        
        boolean isBounded = ((cx == sx) && (cy == sy)) || dir != 0;
        return isBounded;
    }
}
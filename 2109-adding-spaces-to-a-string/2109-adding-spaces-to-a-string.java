class Solution {
    public String addSpaces(String s, int[] spaces) {
        
        StringBuilder res = new StringBuilder(s);
        int esp = 0;
        for(int i = 0; i < spaces.length; i++){
            int idx = spaces[i] + esp;
            res.insert(idx, " ");
            esp++;
        }
        
        return res.toString();
    }
}
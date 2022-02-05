class Solution {
    
    enum Log{
        LETTER, DIGIT;
    }
    class Pair implements Comparable<Pair> {
        Log type ;
        int idx;
        String[] words;
        String os;
        
        Pair(Log type, int idx, String[] words, String os){
            this.type = type;
            this.idx = idx;
            this.words = words;
            this.os = os;
        }
        
        public int compareTo(Pair op){
            if(this.type == Log.LETTER && op.type == Log.LETTER){
                int cmp = this.words[1].compareTo(op.words[1]);
                if(cmp != 0){
                    return cmp;
                }
                return this.words[0].compareTo(op.words[0]);
            }
            else if(this.type == Log.DIGIT && op.type == Log.DIGIT){
                return 0;
            }
            else if(this.type == Log.LETTER && op.type == Log.DIGIT){
                return -1;
            }
            else{
                // this is digit and o is letter
                return 1;
            }
        }
    }
    public String[] reorderLogFiles(String[] logs) {
        Pair[] wps = new Pair[logs.length];
        
        for(int i = 0; i < logs.length; i++){
            String[] logWords = logs[i].split(" ", 2);
            Log type = Log.LETTER;
            if(Character.isDigit(logWords[1].charAt(0))){
                type = Log.DIGIT;
            }
            wps[i] = new Pair(type, i, logWords, logs[i]);
        }
        
        Arrays.sort(wps);
        
        String[] res = new String[logs.length];
        int i = 0;
        for(Pair pair: wps){
            res[i] = pair.os;
            i++;
        }
        
        return res;
    }
}
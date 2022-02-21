class Solution {
    public String reverseVowels(String s) { 
        int i = 0;
        int j = s.length() - 1;

        while(i < j){
             boolean ci = isVowel(s.charAt(i));
             boolean cj = isVowel(s.charAt(j));
             if(ci && cj){
                 // swap
                 // add i to 
                 s = swap(s, i, j);
                 i++;
                 j--;
             }
             else if(ci){
                 // add j to the end of the response
                 j--;
             }
             else{
                 // add i to the continuation of the response
                 i++;
             }
        }
        
        return s;
    }
    
    public String swap(String s, int i, int j){
        String first = s.substring(0, i);
        String mid = s.substring(i + 1, j);
        String end = s.substring(j + 1);
        return first + s.charAt(j) + mid + s.charAt(i) + end;
    }
    
    public boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
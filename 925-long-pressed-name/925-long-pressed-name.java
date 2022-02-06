class Solution {
    public boolean isLongPressedName(String name, String typed) {
        if(name.length() > typed.length()){
            return false;
        }
        
        int i = 0;
        int j = 0;
        
        while(i < name.length() && j  < typed.length()){            
            if(typed.charAt(j) == name.charAt(i)){
                i++;
                j++;
            }
            else if(i > 0 && typed.charAt(j) == name.charAt(i - 1)){
                j++;
            }
            else {
                return false;
            }
        }
        
        while(j < typed.length()){
            if(typed.charAt(j) != name.charAt(i - 1)){
                return false;
            }
            j++;
        }
        
        
        return i < name.length() ? false : true;
    }
}
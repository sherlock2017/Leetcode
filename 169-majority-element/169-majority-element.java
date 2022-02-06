class Solution {
    public int majorityElement(int[] nums) {
        // find the possible majority element
        int possibleMajorityElement = findPossibleMajorityElement(nums);
        return possibleMajorityElement;
    }

    public int findPossibleMajorityElement(int[] arr){
        int value = arr[0];
        int count = 1;
        
        for(int i = 1; i < arr.length; i++){
            if(arr[i] == value){
                count++;
            }
            else{
                count--;
            }
            
            if(count == 0){
                value = arr[i];
                count = 1;
            }
        }
        return value;
    }
}
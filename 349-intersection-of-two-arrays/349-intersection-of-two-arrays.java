class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> inter = new HashSet<>();
        for(int num: nums1){
            set.add(num);
        }
        
        for(int num: nums2){
            if(set.contains(num)){
                inter.add(num);
            }
        }
        
        int[] res = new int[inter.size()];
        int i = 0;
        
        for(int num : inter){
            res[i] = num;
            i++;
        }
        return res;
    }
}
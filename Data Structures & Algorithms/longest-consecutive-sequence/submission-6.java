class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0)return 0;
        Set<Integer> set = new HashSet<>();
        for(int val : nums){
            set.add(val);
        }

        int max=1; 
        for(int num : nums){
            int len=1; 
            if(!set.contains(num-1)){
                while(set.contains(num+len)){
                    len++;
                }
                max= Math.max(len,max);
            }
        }
        return max;
    }
}
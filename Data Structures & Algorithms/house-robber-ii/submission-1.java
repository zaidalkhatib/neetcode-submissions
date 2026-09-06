class Solution {
    // Map<Integer,Integer> map = new HashMap<>();
    public int rob(int[] nums) {
        if(nums.length==1)return nums[0];
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();
        return Math.max(helper(nums,1,nums.length-1,map1),helper(nums,0,nums.length-2,map2));
    }
    private int helper(int [] nums, int index,int lastIndex,Map<Integer,Integer> map){
        if(map.containsKey(index)){
            return map.get(index);
        }
        if(index>lastIndex){
            return 0;
        }
        int take = nums[index]+helper(nums,index+2,lastIndex,map);
        int notTake = helper(nums,index+1,lastIndex,map);
        map.put(index, Math.max(take,notTake));
        return Math.max(take,notTake);
    }
}

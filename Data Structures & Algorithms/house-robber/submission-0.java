class Solution {
    Map<Integer,Integer> map = new HashMap<>();
    public int rob(int[] nums) {
        if(nums.length==1)return nums[0];
        return helper(nums,0);
    }
    private int helper(int [] nums, int index){
        if(map.containsKey(index)){
            return map.get(index);
        }
        if(index>=nums.length){
            return 0;
        }
        int take = nums[index]+helper(nums,index+2);
        int notTake = helper(nums,index+1);
        map.put(index, Math.max(take,notTake));
        return map.get(index);
    }
}


/*

[1,1,3,3]

 1
/
3

*/
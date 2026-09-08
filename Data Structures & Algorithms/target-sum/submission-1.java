class Solution {
    Map<String,Integer> map = new HashMap<>();
    public int findTargetSumWays(int[] nums, int target) {
        
        return helper(nums,0,0,target);
    }

    private int helper(int [] nums, int index,int curr,int target){
        if(index>=nums.length){
            if(curr==target){
                return 1;
            }
            return 0;
        }
        String key = curr+"-"+index;
        if(map.containsKey(key)){
            return map.get(key);
        }

        int add = helper(nums,index+1,curr+nums[index],target);
        int sub = helper(nums,index+1,curr-nums[index],target);
        map.put(key,add+sub);
        return add+sub;
    }
}

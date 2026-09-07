class Solution {
    Set<Integer> set = new HashSet<>();
    Map<Integer,Boolean> map = new HashMap<>();
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int  num : nums){
            sum+=num;
        }

        return helper(nums,0,sum,0);
    }
    private boolean helper(int [] nums, int index, int sum,int curr){
        if(map.containsKey(sum)){
            return map.get(sum);
        }
        if(curr>sum){
            return false;
        }
        // System.out.println(sum+ " "+curr);
        if(sum==curr){
            return true;
        }
        if(index>=nums.length){
            return false; 
        }
        boolean take = helper(nums,index+1,sum-nums[index],curr+nums[index]);
        boolean dont= helper(nums,index+1,sum,curr);
        map.put(sum,(take||dont));
        return take||dont;
    }
}

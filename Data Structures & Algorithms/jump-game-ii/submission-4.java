class Solution {
    Map<Integer,Integer> map = new HashMap<>();
    public int jump(int[] nums) {
        
        return helper(nums,0);
    }

    private int helper(int [] nums,int index){
        if(index>=nums.length-1){
            return 0;
        }
        if(map.containsKey(index)){
            return map.get(index);
        }
        int res=10000;
        for(int i=index+1 ;i<=nums[index]+index ;i++){
            res = Math.min(res,1+helper(nums,i));
        }
        map.put(index,res);
        return res;
    }
}

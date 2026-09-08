class Solution {
    Map<Integer,Boolean> map = new HashMap<>();
    public boolean canJump(int[] nums) {

        return helper(nums,0);
    }


    private boolean helper( int [] nums, int index){
        if(index>=nums.length-1){
            return true;
        }
        if(map.containsKey(index)){
            return map.get(index);
        }
        
        for(int i=index+1 ;i<=index+nums[index] ; i++){
            boolean res = helper(nums,i);
            map.put(index,res);
            if(res){
                return true;
            }
        }
        return false;
    }
}

//1,2,0,1,0
// 0
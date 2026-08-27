class Solution {
    public int[] productExceptSelf(int[] nums) {
        // result array
        int [] forwards = new int [nums.length];
        forwards[0]=1;
        int [] backwords = new int [nums.length];
        backwords[backwords.length-1]=1;
        for(int i=0 ;i<nums.length-1 ;i++){
            forwards[i+1]=forwards[i]*nums[i];
        }
        for(int i=nums.length-1 ;i>=1 ; i--){
            backwords[i-1]=backwords[i]*nums[i];
        }
        for(int i=0 ; i<nums.length ;i++){
            forwards[i]*=backwords[i];
        }
        return forwards;
    }
}  

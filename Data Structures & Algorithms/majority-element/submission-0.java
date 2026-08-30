class Solution {
    public int majorityElement(int[] nums) {
        int count=0;
        int majority = nums[0];
        for(int val : nums){
            if(count==0){
                majority=val;
            }
            if(val==majority){
                count++;
            }
            if(val!=majority) count--;
            if(count==0) majority=val;
        }
        return majority;
    }
}
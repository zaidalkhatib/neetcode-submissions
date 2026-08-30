class Solution {
    public int removeElement(int[] nums, int val) {
        int index=nums.length-1;
        for(int i=0 ;i<nums.length ;i++){
            if(index<=i)break;
            if(nums[i]==val){
                while(index>i&&nums[index]==val){
                    index--;
                }
                nums[i]=nums[index];
                nums[index]=val;
                index--;
            }
        }
        for(int i=0 ;i<nums.length ;i++){
            if(nums[i]==val){
                return i;
            }
        }
        return nums.length;
    }
}
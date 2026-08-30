class Solution {
    public void sortColors(int[] nums) {
        int zeros = 0;
        int twos=nums.length-1;
        int i=0;
        while(i<=twos){
            if(nums[i]==2){
                int temp = nums[i];
                nums[i]=nums[twos];
                nums[twos]=temp;

                twos--;
            }else if(nums[i]==0){
                int temp = nums[i];
                nums[i]=nums[zeros];
                nums[zeros]=temp;
                i++;
                zeros++;
            }else{
                i++;
            }
        }
    }
}
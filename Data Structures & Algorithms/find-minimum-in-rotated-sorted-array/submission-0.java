class Solution {
    public int findMin(int[] nums) {
        int smallestIndex = findPiv(nums);
        return nums[smallestIndex];
    }

    private static int findPiv(int [] nums){
        int left=0;
        int right =nums.length-1;
        while(left<=right){
            int mid = (right+left)/2;
            if(nums[mid]>nums[nums.length-1]){
                left= mid+1;
            }else{
                right = mid-1;
            }
        }
        return left;
    }
}

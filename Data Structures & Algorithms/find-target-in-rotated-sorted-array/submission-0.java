class Solution {
    public int search(int[] nums, int target) {
        int smallestIndex = findPiv(nums);
        int leftValue = binarySearch(smallestIndex,nums.length-1,nums,target);
        if(leftValue!=-1)return leftValue;
        return binarySearch(0,smallestIndex-1,nums,target);
    }

    private static int binarySearch(int left,int right,int [] nums,int target){
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                right = mid-1;
            }else{
                left=mid+1;
            }
        }
        return -1;
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
/*
3,4,5,6,1,2

*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0 ;i<nums.length ;i++){
            if(i!=0&&nums[i]==nums[i-1]){
                continue;
            }
            int currNum = nums[i];
            int left=i+1;
            int right=nums.length-1;
            while(left<right){
                int currSum = currNum +nums[left]+nums[right];
                if(currSum==0){
                    res.add(List.of(nums[i],nums[left],nums[right]));
                    left++;
                    while(left<right&&nums[left]==nums[left-1]){
                        left++;
                    }
                    right--;
                    while(left<right&&nums[right]==nums[right+1]){
                        right--;
                    }
                }else if(currSum>0){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return res;
    }
}

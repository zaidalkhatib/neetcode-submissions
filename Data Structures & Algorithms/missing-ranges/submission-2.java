class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length==0){
            res.add(List.of(lower,upper));
            return res;
        }
        if(nums[0]!=lower){
            res.add(List.of(lower,nums[0]-1));
        }

        for(int i =0 ;i<nums.length-1;i++){
            if(Math.abs(nums[i]-nums[i+1])>1){
                res.add(List.of(nums[i]+1,nums[i+1]-1));
            }
        }


        if(upper!=nums[nums.length-1]){
            res.add(List.of(nums[nums.length-1]+1,upper));
        }
        return res;
    }
}

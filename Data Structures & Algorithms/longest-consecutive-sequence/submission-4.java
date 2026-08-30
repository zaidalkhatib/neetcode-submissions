class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0)return 0;
        Map<Integer,Integer> map = new HashMap<>();

        Arrays.sort(nums);
        int max=1;
        int count=1;
        for(int i=0 ;i<nums.length-1 ;i++){
            if(nums[i+1]-nums[i]==1){
                count++;
                max = Math.max(count,max);
            }
            else if(nums[i]==nums[i+1]){
                continue;
            }else if(nums[i+1]-nums[i]>1){
                count=1;
            }
        }

        return max;
    }
}


/*


[2,20,4,10,3,4,5]


[2,3,4,5,10,20]


//0,3,2,5,4,6,1,1
[0,1,1,2,3,4,5,6]

[9,7,8,6]
[-1,-1,0,1,3,4,5,6,7,8,9]

*/
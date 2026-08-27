class Solution {
    public int[] getConcatenation(int[] nums) {
        int [] ans = new int [nums.length*2];
        int index=0;
        for(int i=0;i<ans.length ;i++){
            if(index>=nums.length){
                index=0;
            }
            ans[i]=nums[index++];
        }
        return ans;
    }
}
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(nums,temp,res,0);
 
        return new ArrayList<>(res);
    }


    private static void backtrack(int [] nums, List<Integer> temp, Set<List<Integer>> res,int index){
        if(index>=nums.length){
            res.add(new ArrayList<Integer>(temp)); 
            return;
        }
        backtrack(nums,temp,res,index+1); 
        temp.add(nums[index]);
        backtrack(nums,temp,res,index+1);
        temp.remove(temp.size()-1); 
    }
}

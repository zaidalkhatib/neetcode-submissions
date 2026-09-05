class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(nums,temp,res,0);
 
        return res;
    }


    private static void backtrack(int [] nums, List<Integer> temp, List<List<Integer>> res,int index){
        if(index>=nums.length){
            res.add(new ArrayList<Integer>(temp)); 
            return;
        }
        temp.add(nums[index]);
        backtrack(nums,temp,res,index+1); 
        temp.remove(temp.size()-1); 
        backtrack(nums,temp,res,index+1);
    }

}
/*
   []
   / \
  [1] [2]
  / \
      [1,3]
  [1,2]
  /
  [1,2,3]

*/
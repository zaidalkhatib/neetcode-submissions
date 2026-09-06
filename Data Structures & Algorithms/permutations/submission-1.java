class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums,new ArrayList<Integer>(),res);
        return res;
    }

    private static void helper(int []nums,List<Integer> temp, List<List<Integer>> res){
        if(temp.size()==nums.length){
            res.add(new ArrayList(temp));
            return;
        }

        for(int num : nums){
            if(!temp.contains(num)){
                temp.add(num);
                helper(nums,temp,res);
                temp.remove(temp.size()-1);
            }
        }
    }


}

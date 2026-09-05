class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> res = new HashSet<>();

        helper(candidates,target,0,new ArrayList<Integer>(),res);
        return new ArrayList<>(res);
    }

    private static void helper(int []candidates,int target, int index,ArrayList<Integer> temp, Set<List<Integer>> res){
        if(target==0){
            res.add(new ArrayList<>(temp));
            return;
        }
        if(target<0||index>=candidates.length){
            return;
        }
        temp.add(candidates[index]);
        helper(candidates,target-candidates[index],index+1,temp,res);
        temp.remove(temp.size()-1);
             while (index + 1 < candidates.length && candidates[index] == candidates[index + 1]) {
            index++;
        }
        helper(candidates,target,index+1,temp,res);
    }
}

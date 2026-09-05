class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Set<List<Integer>> set = new HashSet<>();
        backtrack(nums,0,target,new ArrayList<Integer>(),set);
        return new ArrayList<>(set);
    }
    private static void backtrack(int [] nums,int index,int target,List<Integer> temp,  Set<List<Integer>> set){
        if(target<0 ||index>=nums.length){
            return;
        }
        if(target==0){
            List<Integer> newTemp = new ArrayList<>(temp);
            Collections.sort(newTemp);
            set.add(newTemp);
            return;
        }
        // System.out.print(temp);
        temp.add(nums[index]);
        backtrack(nums,index,target-nums[index],temp,set);
        temp.remove(temp.size()-1);
        backtrack(nums,index+1,target,temp,set);
    }
}

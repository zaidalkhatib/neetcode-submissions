class Solution {
    public int removeDuplicates(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0 ;i<nums.length ;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(map.get(nums[i])>2){
                continue;
            }
            list.add(nums[i]);
        }

        for(int i=0 ;i<list.size() ;i++){
            nums[i]=list.get(i);
        }
        return list.size();
    }
}
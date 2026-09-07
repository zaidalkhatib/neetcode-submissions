class Solution {
    Map<String, Integer> map = new HashMap<>();
    public int lengthOfLIS(int[] nums) {
        return helper(nums, 0, Integer.MIN_VALUE);
    }

    private int helper(int[] nums, int index, int prev) {
        String key = index + " " + prev;
        if (map.containsKey(key))
            return map.get(key);
        if (index >= nums.length) {
            return 0;
        }
        int take =0;
        if (nums[index] > prev) {
            take = 1 + helper(nums, index + 1, nums[index]);
        }

        int dont = helper(nums, index + 1, prev);
        map.put(key, Math.max(take, dont));
        return Math.max(take, dont);
    }
}

class Solution {
    Map<String, Integer> map = new HashMap<>();
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
        return helper(profit, weight, capacity, 0);
    }

    private int helper(List<Integer> profit, List<Integer> weight, int capacity, int index) {
        if (capacity < 0) {
            return Integer.MIN_VALUE;
        }
        if (index >= profit.size())
            return 0;
        String key = index + " " + capacity;
        if (map.containsKey(key))
            return map.get(key);

        int take = profit.get(index) + helper(profit, weight, capacity - weight.get(index), index);
        int donttake = helper(profit, weight, capacity, index + 1);
        map.put(key, Math.max(take, donttake));
        return Math.max(take, donttake);
    }
}

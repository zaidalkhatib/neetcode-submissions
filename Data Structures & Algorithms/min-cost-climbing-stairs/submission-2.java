class Solution {
    Map<Integer,Integer> map = new HashMap<>();
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(minCost(cost,0),minCost(cost,1));
    }

    private  int minCost(int[] cost ,int index){
        if(map.containsKey(index))return map.get(index);
        if(index==cost.length){
            return 0;
        }
        if(index>cost.length) return Integer.MAX_VALUE;

        int res= cost[index]+Math.min(minCost(cost,index+1),minCost(cost,index+2));

        map.put(index,res);

        return res;
    }
}

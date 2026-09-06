class Solution {
    Map<Integer,Integer> map = new HashMap<>();
    public int climbStairs(int n) {
        if(n==0){
            return 1;
        }
        if(n<0)return 0;
        if(map.containsKey(n))return map.get(n);
         int res = climbStairs(n-2)+climbStairs(n-1);
         map.put(n,res);
         return res;
    }
}

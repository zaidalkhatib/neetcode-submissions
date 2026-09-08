class Solution {
    Map<String,Integer> map = new HashMap<>();
    public int change(int amount, int[] coins) {

        return helper(amount,coins,0);
    }

    private  int helper(int amount,int [] coins, int index){
        if(amount==0){
            return 1;
        }
        if(amount<0||coins.length<=index){
            return 0;
        }
        String key = amount + "|"+ index;
        if(map.containsKey(key)) return map.get(key);
        int take = helper(amount-coins[index],coins,index);
        int dont=helper(amount,coins,index+1);
        map.put(key,take+dont);
        return take+dont;
    }
}

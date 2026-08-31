class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int sell = Integer.MIN_VALUE;
        int buy = Integer.MAX_VALUE;
        for(int price : prices){
            if(price<buy){
                buy=price;
            }else{
                profit = Math.max(price-buy,profit);
            }
        }
        return profit;
    }
}

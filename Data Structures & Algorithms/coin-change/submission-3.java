class Solution {
    public int coinChange(int[] coins, int amount) {
        Double[][] memo = new Double[coins.length][amount + 1];

        double res = helper(coins, amount, 0, memo);

        return res == Double.POSITIVE_INFINITY ? -1 : (int) res;
    }

    private static double helper(
        int[] coins,
        int amount,
        int index,
        Double[][] memo
    ) {
        if (amount == 0) {
            return 0;
        }

        if (amount < 0 || index >= coins.length) {
            return Double.POSITIVE_INFINITY;
        }

        if (memo[index][amount] != null) {
            return memo[index][amount];
        }

        double take =
            1 + helper(coins, amount - coins[index], index, memo);

        double notTake =
            helper(coins, amount, index + 1, memo);

        memo[index][amount] = Math.min(take, notTake);

        return memo[index][amount];
    }
}
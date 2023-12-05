class Solution {

    public int minCoins(int coins[], int n, int target) {
        int dp[][] = new int[n][target + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        if (recursion(0, n, target, coins, dp) >= Integer.MAX_VALUE) {
            return -1;
        }
        return recursion(0, n, target, coins, dp);
    }

    public int recursion(int index, int n, int target, int coins[], int dp[][]) {
        if (index == n || target < 0)
            return Integer.MAX_VALUE;
        if (target == 0)
            return 0;

        if (dp[index][target] != -1) {
            return dp[index][target];
        }
        int pick = recursion(index, n, target - coins[index], coins, dp);

        if (pick != Integer.MAX_VALUE) {
            pick += 1;
        }

        int notPick = recursion(index + 1, n, target, coins, dp);

        return dp[index][target] = Math.min(pick, notPick);
    }
}
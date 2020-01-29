// Summary
// We have to determine the maximum profit that can be obtained by making the transactions 
// (no limit on the number of transactions done). 
// For this we need to find out those sets of buying and selling prices which together lead to the maximization of profit.

// Solution
// Approach 1: Brute Force
// In this case, we simply calculate the profit corresponding to all the possible sets of transactions 
// and find out the maximum profit out of them.

// Complexity Analysis

// Time complexity : O(n^n) Recursive function is called n^n times.

// Space complexity : O(n). Depth of recursion is n.


class Solution {
    public int maxProfit(int[] prices) {
        return calculate(prices, 0);
    }

    public int calculate(int prices[], int s) {
        if (s >= prices.length)
            return 0;
        int max = 0;
        for (int start = s; start < prices.length; start++) {
            int maxprofit = 0;
            for (int i = start + 1; i < prices.length; i++) {
                if (prices[start] < prices[i]) {
                    int profit = calculate(prices, i + 1) + prices[i] - prices[start];
                    if (profit > maxprofit)
                        maxprofit = profit;
                }
            }
            if (maxprofit > max)
                max = maxprofit;
        }
        return max;
    }
}
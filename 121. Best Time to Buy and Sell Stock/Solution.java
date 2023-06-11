class Solution {
    public int maxProfit(int[] prices) {
        // Initialize the minimum price to the first element in the array
        int mini = prices[0];
        
        // Initialize the profit to 0
        int profit = 0;
        
        // Get the length of the prices array
        int n = prices.length;
        
        // Iterate over the prices array starting from the second element
        for (int i = 1; i < n; i++) {
            // Calculate the profit by subtracting the current price from the minimum price
            // Take the maximum value between the current profit and the new calculated profit
            profit = Math.max(profit, prices[i] - mini);
            
            // Update the minimum price by taking the minimum value between the current minimum price and the current price
            mini = Math.min(mini, prices[i]);
        }
        
        // Return the maximum profit
        return profit;
    }
    public static void main(String[] args) {
        int prices[] = {7, 1, 5, 3, 6, 4};
        Solution s = new Solution();
        System.out.println(s.maxProfit(prices));
    }
}

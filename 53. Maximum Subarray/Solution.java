class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        
        // If there is only one element in the array, return that element
        if (n == 1) {
            return nums[0];
        }
        
        int maxSum = Integer.MIN_VALUE;  // Variable to store the maximum sum
        int currentSum = 0;  // Variable to track the current sum
        
        for (int i = 0; i < n; i++) {
            currentSum += nums[i];  // Add the current element to the current sum
            
            // Update the maximum sum if the current sum is greater
            maxSum = Math.max(maxSum, currentSum);
            
            // If the current sum becomes negative, reset it to 0
            currentSum = Math.max(currentSum, 0);
        }
        
        return maxSum;
    }

    public static void main(String[] args) {
        
        int nums[]={-2,1,-3,4,-1,2,1,-5,4};
        Solution s = new Solution();
       
        System.out.println(s.maxSubArray(nums));
    }
}

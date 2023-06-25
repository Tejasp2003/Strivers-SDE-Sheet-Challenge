class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int count = 1;
        int majorityElement = nums[0];
        
        // Find the majority element using the Boyer-Moore Voting Algorithm
        for (int i = 1; i < n; i++) {
            // If the count becomes 0, update the majority element
            if (count == 0) {
                majorityElement = nums[i];
            }
            
            // If the current element is equal to the majority element, increment the count
            if (nums[i] == majorityElement) {
                count++;
            } else {
                // If the current element is different, decrement the count
                count--;
            }
        }
        
        // Return the majority element
        return majorityElement;
    }
    public static void main(String[] args){
        int [] nums = {2,2,1,1,1,2,2};
        Solution s = new Solution();
        System.out.println(s.majorityElement(nums));
    }
}

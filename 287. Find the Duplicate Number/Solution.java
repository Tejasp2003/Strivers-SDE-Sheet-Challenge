class Solution {
    public int findDuplicate(int[] nums) {
        // Check if the array is empty
        if (nums.length < 1)
            return -1;

        // Initialize the slow pointer to the first element
        int slow = nums[0];
        // Initialize the fast pointer to the element at index nums[0]
        int fast = nums[nums[0]];

        // Find the meeting point of the slow and fast pointers
        while (slow != fast) {
            // Move the slow pointer one step forward
            slow = nums[slow];
            // Move the fast pointer two steps forward
            fast = nums[nums[fast]];
        }

        // Reset the fast pointer to the beginning
        fast = 0;

        // Find the starting point of the cycle (duplicate number)
        while (slow != fast) {
            // Move both pointers one step forward
            fast = nums[fast];
            slow = nums[slow];
        }

        // Return the duplicate number
        return slow;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(s.findDuplicate(nums));
    }
}

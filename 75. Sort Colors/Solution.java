class Solution {
    public void sortColors(int[] nums) {
        int low = 0; // Pointer for the 0's section
        int high = nums.length - 1; // Pointer for the 2's section
        int mid = 0; // Pointer for traversal

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++; // Increment low pointer to move towards the end of the 0's section
                mid++; // Increment mid pointer to move towards the end of the processed section
            } else if (nums[mid] == 1) {
                mid++; // Increment mid pointer to move towards the end of the processed section
                // No swapping required as 1's remain in the middle
            } else {
                swap(nums, mid, high);
                high--; // Decrement high pointer to move towards the start of the 2's section
                // We don't increment mid here because the swapped element may need further processing
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }



    public static void main(String[] args) {
        int nums[] = {2, 0, 2, 1, 1, 0};
        Solution s = new Solution();
        s.sortColors(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}

import java.util.*;

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int k, l;
        
        // Find the largest index k such that nums[k] < nums[k+1]
        for (k = n - 2; k >= 0; k--) {
            if (nums[k] < nums[k + 1]) {
                break;
            }
        }
        
        // If k is not found, the array is in descending order
        // Reverse the array to obtain the next permutation
        if (k < 0) {
            reverse(nums, 0, n - 1);
        } else {
            // Find the largest index l such that nums[l] > nums[k]
            for (l = n - 1; l > k; l--) {
                if (nums[l] > nums[k]) {
                    break;
                }
            }
            
            // Swap nums[k] and nums[l]
            swap(nums, k, l);
            
            // Reverse the elements after index k
            reverse(nums, k + 1, n - 1);
        }
    }

    // Helper method to reverse elements in the array from start index to end index
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    // Helper method to swap two elements in the array
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
    int nums[]= {1,2,3,4};
    Solution s = new Solution();
    s.nextPermutation(nums);
    System.out.println(Arrays.toString(nums));

    }
}

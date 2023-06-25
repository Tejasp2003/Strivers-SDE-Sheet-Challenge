import java.util.*;
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length; // Size of the array

        int count1 = 0, count2 = 0; // Counts for two potential majority elements
        int element1 = Integer.MIN_VALUE; // First potential majority element
        int element2 = Integer.MIN_VALUE; // Second potential majority element

        // Applying the Extended Boyer-Moore's Voting Algorithm:
        for (int i = 0; i < n; i++) {
            if (count1 == 0 && element2 != nums[i]) {
                count1 = 1;
                element1 = nums[i];
            } else if (count2 == 0 && element1 != nums[i]) {
                count2 = 1;
                element2 = nums[i];
            } else if (nums[i] == element1) {
                count1++;
            } else if (nums[i] == element2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        List<Integer> result = new ArrayList<>(); // List to store the majority elements

        // Manually check if the stored elements in element1 and element2 are the majority elements:
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == element1) {
                count1++;
            }
            if (nums[i] == element2) {
                count2++;
            }
        }

        int minThreshold = (int) (n / 3) + 1; // Minimum threshold for a majority element

        // Add the majority elements to the result list
        if (count1 >= minThreshold) {
            result.add(element1);
        }
        if (count2 >= minThreshold) {
            result.add(element2);
        }

        // Uncomment the following line if the result list needs to be sorted:
        // Collections.sort(result); // Time Complexity: O(2*log2) ~ O(1)

        // Printing for debugging purposes
        System.out.println(count1 + " " + count2);
        System.out.println(element1 + " " + element2);
        System.out.println(n / 3);

        return result;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 1, 1, 3, 3, 2, 2, 2};
        System.out.println(sol.majorityElement(nums));
    }
}

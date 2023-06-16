class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = n - 1;      // Pointer for nums2 (starting from the last element)
        int j = m - 1;      // Pointer for nums1 (starting from the last element)
        int k = m + n - 1;  // Pointer for the merged array (starting from the last position)

        // Merge elements from nums1 and nums2 until either array is fully merged
        while (j >= 0 && i >= 0) {
            if (nums1[j] > nums2[i]) {
                nums1[k] = nums1[j];  // Place the greater element from nums1 to the merged array
                j--;                  // Move to the previous element in nums1
            } else {
                nums1[k] = nums2[i];  // Place the greater element from nums2 to the merged array
                i--;                  // Move to the previous element in nums2
            }
            k--;                      // Move to the previous position in the merged array
        }

        // Handle any remaining elements in nums2 (if there are any)
        while (i >= 0) {
            nums1[k] = nums2[i];  // Place the remaining elements from nums2 to the merged array
            i--;                  // Move to the previous element in nums2
            k--;                  // Move to the previous position in the merged array
        }
    }

    public static void main(String [] args){
        int [] nums1 = {1,2,3,0,0,0};
        int [] nums2 = {2,5,6};
        Solution s = new Solution();
        s.merge(nums1, 3, nums2, 3);
        for(int i = 0; i < nums1.length; i++){
            System.out.println(nums1[i]);
        }
    }
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Get the number of rows in the matrix
        int row = matrix.length;
        
        // Get the number of columns in the matrix
        int col = matrix[0].length;
        
        // Set the start and end indices for binary search
        int start = 0;
        int end = row * col - 1;
        
        // Perform binary search on the matrix
        while (start <= end) {
            // Calculate the middle index using the start and end indices
            int mid = start + (end - start) / 2;
            
            // Calculate the row and column indices corresponding to the middle index
            int midRow = mid / col;
            int midCol = mid % col;
            
            // If the element at the middle index is equal to the target, return true
            if (matrix[midRow][midCol] == target)
                return true;
            
            // If the element at the middle index is greater than the target,
            // update the end index to search in the lower half of the matrix
            if (matrix[midRow][midCol] > target)
                end = mid - 1;
            
            // If the element at the middle index is less than the target,
            // update the start index to search in the upper half of the matrix
            else
                start = mid + 1;
        }
        
        // If the target is not found in the matrix, return false
        return false;
    }

    public static void main(String[] args){

        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        Solution s= new Solution();
        System.out.println(s.searchMatrix(matrix,target));
    }
}


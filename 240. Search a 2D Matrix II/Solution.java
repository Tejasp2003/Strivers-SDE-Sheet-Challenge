class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Set the initial row index to 0
        int row = 0;
        
        // Set the initial column index to the last column of the matrix
        int col = matrix[0].length - 1;
        
        // Get the total number of rows in the matrix
        int n = matrix.length;
        
        // Iterate until the row index is within the bounds of the matrix and the column index is non-negative
        while (row < matrix.length && col >= 0) {
            // If the current element is equal to the target, return true
            if (matrix[row][col] == target)
                return true;
            
            // If the current element is less than the target, move to the next row (increment row index)
            if (matrix[row][col] < target)
                row++;
            
            // If the current element is greater than the target, move to the previous column (decrement column index)
            else
                col--;
        }
        
        // If the target is not found in the matrix, return false
        return false;
    }
    public static void main(String[] args){
        int [][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target=11;
        Solution s = new Solution();
        System.out.println(s.searchMatrix(matrix,target));
    }
}

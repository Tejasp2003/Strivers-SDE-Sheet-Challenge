import java.util.Arrays;

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int m= matrix[0].length;
        for(int i=0; i<n; i++){
            for(int j=i; j<m; j++){
                int temp= matrix[i][j];
                matrix[i][j]= matrix[j][i];
                matrix[j][i]= temp;

            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m/2; j++){
                int temp = matrix[i][j];
                matrix[i][j]= matrix[i][m-j-1];
                matrix[i][n-j-1]=temp;
            }
        }
    }

   public static void main(String[] args) {
        int matrix[][] = {{1,2,3},{4,5,6},{7,8,9}};
        Solution s = new Solution();
        s.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
   }
}
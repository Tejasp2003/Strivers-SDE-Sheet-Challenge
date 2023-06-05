// class Solution {

    // Time: O(n*m)
    // Space: O(n+m)
    //better approach
    // public void setZeroes(int[][] matrix) {
    //     int n = matrix.length;
    //     int m = matrix[0].length;
    //     int markRow[] = new int[n];
    //     int markCol[] = new int[m];

    //     for(int i=0; i<n; i++){
    //         for(int j=0; j<m; j++){
    //             if(matrix[i][j] ==0){
    //                 markRow[i]=1;
    //                 markCol[j]=1;
    //             }
    //         }
    //     }
    //      for(int i=0; i<n; i++){
    //         for(int j=0; j<m; j++){
    //             if(markRow[i]==1||
    //                 markCol[j]==1){
    //                 matrix[i][j]=0;
    //             }
    //         }
    //     }

        
    //}

    //optimal approach

    //intution :
    //we will use first row and first column as a marker
    //if any element in matrix is zero then we will mark its first row and first column as zero
    //then we will traverse the matrix again and if we find any element as zero then we will mark its first row and first column as zero 

    
    
   class Solution {
    public void setZeroes(int[][] matrix) {
        boolean fr= false, fc=false;
        int n= matrix.length;
        int m= matrix[0].length;
        for(int i=0; i<n; i++){
            for(int j=0; j<m;j++){
                if(matrix[i][j]==0){
                    if(i==0)fr=true;
                    if(j==0)fc=true;
                    matrix[0][j] =0;
                    matrix[i][0]=0;

                }
            }
        }

        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                if(matrix[0][j]==0 || matrix[i][0]==0){
                    matrix[i][j]=0;
                }
            }
        }

        if(fr){
            for(int j=0; j<m; j++){
                matrix[0][j]=0;
            }
        }
        if(fc){
            for(int i=0; i<n; i++){
                matrix[i][0]=0;
            }
        }
        
    }
}
    

// }


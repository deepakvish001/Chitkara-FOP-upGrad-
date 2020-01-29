  public void rotate(int[][] matrix) {
        
        /*
        Approach:
            Step 1: Flip the matrix diagonally (top-left to bottom-right diagonal).
            Step 2: Flip the matrix horizontally (reverse each row).
        
        Complexity analysis: Time: O(m*n). Space: O(1)
        */
        
        int n = matrix.length;
        
        if(n<2) return;
        
        //Step 1: Flipping diagonally.                                               //          0 0 0 0
        //This can be achieved by just flipping cells below the diagonal.            //          1 0 0 0 
        //In a diagram of 4x4 matrix, such cells are marked as 1, for illustration.  //          1 1 0 0
                                                                                     //          1 1 1 0       
        for(int i=1;i<n;i++){                                                       
            for(int j=0;j<i;j++){                                                   
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        //Step 2: Flipping horizontally.                                             //          1 1 0 0
        //This can be achieved by just flipping cells before the mid index.          //          1 1 0 0
        //In a diagram of 4x4 matrix, such cells are marked as 1, for illustration.  //          1 1 0 0
                                                                                     //          1 1 0 0
        for(int i=0;i<n;i++){                                                       
            for(int j=0;j<n/2;j++){                                                 
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = temp;
            }
        }
        
    }
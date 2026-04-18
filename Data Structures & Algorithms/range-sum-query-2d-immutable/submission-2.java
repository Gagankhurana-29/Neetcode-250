class NumMatrix {

    int[][] prefCol;

    public NumMatrix(int[][] matrix) {
        int r=matrix.length, c=matrix[0].length;
        prefCol = new int[r+1][c+1];
        for(int i=0;i<r;i++){
            int preSum = 0;
            for(int j=0;j<c;j++){
                preSum += matrix[i][j];
                int above = prefCol[i][j+1];
                prefCol[i+1][j+1] = preSum+above;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        row1++; col1++; row2++; col2++;
        sum  = prefCol[row2][col2];
        int above = prefCol[row1-1][col2];
        int left = prefCol[row2][col1-1];
        int topLeft = prefCol[row1-1][col1-1]; 
        return sum - above - left + topLeft;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
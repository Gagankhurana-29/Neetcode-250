class NumMatrix {

    int[][] prefCol;

    public NumMatrix(int[][] matrix) {
        int r=matrix.length, c=matrix[0].length;
        prefCol = new int[r][c];
        for(int i=0;i<c;i++){
            for(int j=0;j<r;j++){
                if(j==0)
                {
                     prefCol[j][i] = matrix[j][i];
                     continue;
                }
                prefCol[j][i] = matrix[j][i] + prefCol[j-1][i];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int c=col1; c<=col2;c++){
            sum += prefCol[row2][c];
            if(row1==0) continue;
            sum -=prefCol[row1-1][c];
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
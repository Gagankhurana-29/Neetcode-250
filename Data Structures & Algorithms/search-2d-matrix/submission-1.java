class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;
        int l=0, h=r-1;
        while(l<h){
            if(matrix[l][c-1]<target){
                l++;                
            }
            else if(matrix[l][0]== target){
                return true;
            }
            else{
                h--;
            }
        }

        l = (l+h)/2;
        int s =0;
        int e = c-1;
        while(s<=e){
            int m = s + (e-s)/2;
            if(matrix[l][m]==target){
                return true;
            } 
            else if(matrix[l][m]>target){
                e=m-1;
            }
            else{
                s=m+1;
            }
        }
        return false; 
    }
}

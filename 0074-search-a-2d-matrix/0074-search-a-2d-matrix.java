class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int l = 0;
        int h = rows * cols - 1;
        while(l <= h){
            int m = (l + h) / 2;
            int row = m / cols;
            int col = m % cols;
            if(target == matrix[row][col]){
                return true;
            }
            else if(target < matrix[row][col]){
                h = m - 1;
            }
            else{
                l = m + 1;
            }
        }
        return false;
    }
}
class Solution {
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int numberOfPosses = matrix.length / 2;
        int buffer;
        for (int i = 0; i < row; i++) {
            for (int j = i+1; j < row; j++) {
                buffer = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = buffer;
            }
        }
        int left = 0, right = matrix.length - 1;
        for (int k = 0; k < numberOfPosses; k++) {
            for (int l = 0; l < matrix[0].length; l++) {
                buffer = matrix[l][left];
                matrix[l][left] = matrix[l][right];
                matrix[l][right] = buffer;
            }
            left++;
            right--;
        }
    }
}
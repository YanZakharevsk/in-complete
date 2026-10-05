import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int numberOfElements = matrix.length * matrix[0].length;
        List<Integer> resultArray = new ArrayList<>();
        int rowsRunner = 0;
        int colRunner = 0;
        boolean firstRow = true;
        boolean lastColumn = false;
        boolean lastRow = false;
        boolean firstColumn = false;
        for (int i = 0; i < numberOfElements; i++) {
            if(colRunner == matrix[0].length){
                firstRow = false; lastColumn = true;
                rowsRunner++; colRunner--;
            }
            if(rowsRunner == matrix.length){
                lastColumn = false; lastRow = true;
                colRunner--; rowsRunner--;
            }
            if(firstRow && matrix[rowsRunner][colRunner] != 101 ){
                resultArray.add(matrix[rowsRunner][colRunner]);
                matrix[rowsRunner][colRunner++] = 101;
                continue;
            }
            if(lastColumn && matrix[rowsRunner][colRunner] != 101){
                resultArray.add(matrix[rowsRunner][colRunner]);
                matrix[rowsRunner++][colRunner] = 101;
                continue;
            }
            if(colRunner == 0){
                lastRow =  false; firstColumn = true;
                rowsRunner--;
            }
            if(lastRow && matrix[rowsRunner][colRunner] != 101){
                resultArray.add(matrix[rowsRunner][colRunner]);
                matrix[rowsRunner][colRunner--] = 101;
                continue;
            }
            if(rowsRunner == 0){
                firstColumn = false; firstRow = true;
                rowsRunner++; colRunner++;
            }

            if(firstColumn && matrix[rowsRunner][colRunner] != 101){
                resultArray.add(matrix[rowsRunner][colRunner]);
                matrix[rowsRunner--][colRunner] = 101;
                continue;
            }

        }
        return resultArray;
    }
    // 0,0  0,1  0,2 0,3
    // 1,3  2,3
    // 2,2  2,1 2,0
    // 1,0

    // 1,1 1,2
}
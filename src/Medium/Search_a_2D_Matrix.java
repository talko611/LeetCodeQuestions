package Medium;
//Question 74
//Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
//Integers in each row are sorted from left to right.
//The first integer of each row is greater than the last integer of the previous row.
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//Output: true

public class Search_a_2D_Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int minRow = 0;
        int maxRow = matrix.length -1;
        int minCol = 0, maxCol = matrix[0].length -1;
        int middleRow;
        int middleVal;
        while(minRow <= maxRow){
            middleRow = (maxRow + minRow) /2;
            if(target >= matrix[middleRow][minCol] && target <= matrix[middleRow][maxCol]){
                while(minCol <= maxCol){
                    middleVal = (maxCol + minCol ) / 2;
                    if(matrix[middleRow][middleVal] == target) return true;
                    if(matrix[middleRow][middleVal] > target) {
                        maxCol = middleVal -1;
                    }else{
                        minCol = middleVal +1;
                    }
                }
                return false;
            }else if( target < matrix[middleRow][minCol]){
                maxRow = middleRow -1;
            }else{
                minRow = middleRow + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] ints = new int [][]{{1,3,5}};
        Search_a_2D_Matrix solution = new Search_a_2D_Matrix();
        System.out.println(solution.searchMatrix(ints, 4));
    }
}

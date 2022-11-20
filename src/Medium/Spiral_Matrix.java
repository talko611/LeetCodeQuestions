package Medium;

//Question 54
//Given an m x n matrix, return all elements of the matrix in spiral order.

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Spiral_Matrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int row = 0;
        int col = 0;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int direction = 0;
        result.add(matrix[0][0]);
        visited[0][0] = true;
        while(!isFinish(row, col, visited)){
            switch (direction) {
                case 0 -> ++col;
                case 1 -> ++row;
                case 2 -> --col;
                case 3 -> --row;
            }
            while(row >= 0 && col >=0 && row < matrix.length && col < matrix[0].length && !visited[row][col]){
                result.add(matrix[row][col]);
                visited[row][col] = true;
                switch (direction) {
                    case 0 -> ++col;
                    case 1 -> ++row;
                    case 2 -> --col;
                    case 3 -> --row;
                }
            }
            boolean flag = true;
            if(row == visited.length ){
                --row;
                flag = false;
            }
            if(row == -1){
                row = 0;
                flag = false;
            }
            if(col == visited[0].length){
                --col;
                flag = false;
            }
            if(col == -1){
                col = 0;
                flag = false;
            }
            if(visited[row][col] && flag)
                switch (direction){
                case 0 -> --col;
                case 1 -> --row;
                case 2 -> ++col;
                case 3 -> ++row;
                }
            direction = (direction + 1) % 4;
        }
        return result;
    }
    private boolean isFinish(int row, int col, boolean[][]visited){
        boolean answer = true;
        if(row < visited.length -1)
            answer = visited[row + 1][col];
        if(row > 0)
            answer = answer && visited[row -1][col];
        if(col < visited[0].length -1)
            answer = answer && visited[row][col + 1];
        if(col > 0)
            answer = answer && visited[row][col - 1];

        return answer;
    }

    public static void main(String[] args) {
        int[][] ints = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        for (int[] anInt : ints) {
            for (int j = 0; j < ints[0].length; ++j) {
                System.out.print(anInt[j] + " ");
            }
            System.out.print("\n");
        }
        Spiral_Matrix solution = new Spiral_Matrix();
        System.out.println(solution.spiralOrder(ints));
    }
}

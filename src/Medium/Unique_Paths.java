package Medium;

//Question 62

//There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]).
// The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
//Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
//Example
//Input: m = 3, n = 7
//        Output: 28

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Unique_Paths {
    public int uniquePaths(int m, int n) {
        if(m == 1 || n == 1) return 1;
        int [][] grid = new int[m][n];
        int i;
        for( i = 1; i < m; ++i)
            grid[i][0] = 1;
        for( i = 1; i < n; ++i)
            grid[0][i] = 1;
        for(i = 1; i < m; ++i){
            for(int j = 1; j < n; ++j){
                grid[i][j] = grid[i -1][j] + grid[i][j -1];
            }
        }
        return grid[m-1][n-1];
    }

    public static void main(String[] args) {
        Unique_Paths unique_paths = new Unique_Paths();
        System.out.println(unique_paths.uniquePaths(3, 1));
    }
}

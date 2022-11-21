package Medium;

//Question 1706

//You have a 2-D grid of size m x n representing a box, and you have n balls. The box is open on the top and bottom sides.
//Each cell in the box has a diagonal board spanning two corners of the cell that can redirect a ball to the right or to the left.
//A board that redirects the ball to the right spans the top-left corner to the bottom-right corner and is represented in the grid as 1.
//A board that redirects the ball to the left spans the top-right corner to the bottom-left corner and is represented in the grid as -1.
//We drop one ball at the top of each column of the box. Each ball can get stuck in the box or fall out of the bottom. A ball gets stuck if it hits a "V" shaped pattern between two boards or if a board redirects the ball into either wall of the box.
//Return an array answer of size n where answer[i] is the column that the ball falls out of at the bottom after dropping the ball from the ith column at the top, or -1 if the ball gets stuck in the box.
//Input: grid = [[1,1,1,-1,-1],[1,1,1,-1,-1],[-1,-1,-1,1,1],[1,1,1,1,-1],[-1,-1,-1,-1,-1]]
//        Output: [1,-1,-1,-1,-1]
//        Explanation: This example is shown in the photo.
//        Ball b0 is dropped at column 0 and falls out of the box at column 1.
//        Ball b1 is dropped at column 1 and will get stuck in the box between column 2 and 3 and row 1.
//        Ball b2 is dropped at column 2 and will get stuck on the box between column 2 and 3 and row 0.
//        Ball b3 is dropped at column 3 and will get stuck on the box between column 2 and 3 and row 0.
//        Ball b4 is dropped at column 4 and will get stuck on the box between column 2 and 3 and row 1.

import java.util.Arrays;

public class Where_Will_the_Ball_Fall {
    public int[] findBall(int[][] grid) {
        int[] result = new int[grid[0].length];
        //init result array
        for(int i = 0; i < grid[0].length; ++i) result[i] = i;
        for (int[] ints : grid) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (result[j] == -1) continue;
                if (result[j] == 0 && ints[result[j]] == -1) result[j] = -1;
                else if (result[j] == result.length - 1 && ints[result[j]] == 1) result[j] = -1;
                else {
                    if (ints[result[j]] == 1) {
                        result[j] = ints[result[j] + 1] == 1 ? result[j] + 1 : -1;
                    } else {
                        result[j] = ints[result[j] - 1] == -1 ? result[j] - 1 : -1;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Where_Will_the_Ball_Fall solution = new Where_Will_the_Ball_Fall();
        int[][] grid = new int[][]{{1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1},{1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1}};
        System.out.println(Arrays.toString(solution.findBall(grid)));
    }
}

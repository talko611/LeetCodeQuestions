package Medium;

//Question 200

//Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
//An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

public class Number_of_Islands {
    public int numIslands(char[][] grid) {
        int numOfIslands = 0;
        for(int i = 0 ; i < grid.length; ++i){
            for(int j = 0; j < grid[0].length; ++j){
                if(grid[i][j] == '1'){
                    visit(grid, i, j);
                    ++numOfIslands;
                }
            }
        }
        return numOfIslands;
    }
    private void visit(char[][] grid, int x , int y){
        if(grid[x][y] == 'v' || grid[x][y] == '0') return;
        grid[x][y] = 'v';
        if(x + 1 < grid.length)
            visit(grid, x + 1, y);
        if(x -1 >= 0)
            visit(grid, x - 1, y);
        if(y +1 < grid[0].length)
            visit(grid, x, y + 1 );
        if( y -1 >= 0)
            visit(grid, x, y - 1);
    }
}

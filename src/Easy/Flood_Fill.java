package Easy;
//Question 733

//An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
//You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].
//To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel,
// plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.
//Return the modified image after performing the flood fill.

public class Flood_Fill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        visit(image,sr,sc, color, image[sr][sc]);
        return image;
    }
    public void visit(int[][] image, int x , int y, int color, int startingColor){
        if(image[x][y] == color || image[x][y] != startingColor) return;
        image[x][y] = color;
        if(x + 1 < image.length)
            visit(image, x + 1, y , color ,startingColor);
        if(x -1 >= 0)
            visit(image, x - 1, y , color ,startingColor);
        if(y +1 < image[0].length)
            visit(image, x, y + 1 , color ,startingColor);
        if( y -1 >= 0)
            visit(image, x, y - 1 , color ,startingColor);
    }
}

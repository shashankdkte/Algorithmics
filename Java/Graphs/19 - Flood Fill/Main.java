import java.util.*;

class Main {

  public void helper(int[][] image,int sourceRow,int sourceCol,int newColor,boolean[][] visited,int orignalColor)
  {
    if(sourceRow<0 || sourceRow>=image.length || sourceCol<0 || sourceCol>=image[0].length || image[sourceRow][sourceCol]!=orignalColor || visited[sourceRow][sourceCol])
    {
      return;
    }
    visited[sourceRow][sourceCol]=true;
    image[sourceRow][sourceCol]=newColor;
    helper(image,sourceRow-1,sourceCol,newColor,visited,orignalColor);
    helper(image,sourceRow+1,sourceCol,newColor,visited,orignalColor);
    helper(image,sourceRow,sourceCol-1,newColor,visited,orignalColor);
    he
  }
  public int[][] floodFill(int [][] image,int sourceRow,int sourceCol,int newColor)
  {
    boolean[][] visited = new boolean[image.length][image[0].length];
    helper(image,sourceRow,sourceCol,newColor,visited,image[sourceRow][sourceCol]);
    return image;
  } 

  
  public static void main(String[] args) {
    System.out.println("Hello world!");
  }
}
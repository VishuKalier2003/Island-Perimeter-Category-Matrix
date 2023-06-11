/* You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents 
water. Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, 
and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes", meaning 
the water inside isn't connected to the water around the island. One cell is a square with side length 1. The grid is 
rectangular, width and height don't exceed 100. Determine the perimeter of the island.
* Eg 1 :  grid = [0,1,0,0]           Perimeter = 16 
*                [1,1,1,0]                          
*                [0,1,0,0]                          
*                [1,1,0,0]                          
* Eg 2 :  grid = [1]                 Perimeter = 4  
* Eg 3 :  grid = [0,1]               Perimeter = 4  
*/
import java.util.*;
public class Perimeter
{
      public int IslandPerimeter(int grid[][])
      {
            if((grid.length == 0) || (grid[0].length == 0))    // Base case...
                  return 0;
            int perimeter = 0;     //* Variable Declaration -> O(1)
            for(int i = 0; i < grid.length; i++)     //! Grid Traversal -> O(N x M)
            {
                  for(int j = 0; j < grid[0].length; j++)
                  {
                        if(grid[i][j] == 1)    // if Grid state is land...
                        {
                              perimeter +=  4;
                              if((j - 1 >= 0) && (grid[i][j - 1] == 1))
                                    perimeter -= 2;   // If two columns are adjacent, perimeter is reduced by 2...
                              if((i - 1 >= 0) && (grid[i - 1][j] == 1))
                                    perimeter -= 2;   // If two rows are adjacent, perimeter is reduced by 2...
                        }
                  }
            }
            return perimeter;
      }
      public void DisplayGrid(int grid[][])
      {
            for(int i = 0; i < grid.length; i++)
            {
                  for(int j = 0; j < grid[0].length; j++)
                        System.out.print(grid[i][j]+", ");
                  System.out.println();
            }
      }
      public static void main(String args[])
      {
            Scanner sc = new Scanner(System.in);
            int row, col;
            System.out.print("Enter number of Rows : ");
            row = sc.nextInt();
            System.out.print("Ënter number of Columns : ");
            col = sc.nextInt();
            int grid[][] = new int[row][col];
            for(int i = 0; i < grid.length; i++)
            {
                  for(int j = 0; j < grid[0].length; j++)
                  {
                        System.out.print("Enter state of "+(i+1)+" row and "+(j+1)+" column : ");
                        grid[i][j] = sc.nextInt();
                  }
            }
            Perimeter perimeter = new Perimeter();     // Object creation...
            perimeter.DisplayGrid(grid);            // Function calling...
            System.out.println("The perimeter of the Island : "+perimeter.IslandPerimeter(grid));
            sc.close();
      }
}



//! Time Complexity -> O(N x M)
//* Space Complexity -> O(1)
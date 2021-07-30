import java.util.Scanner;
public class SampleProgram
{
    public static void main(String[] args)
    {
       int M, N, i, j;   
Scanner sc=new Scanner(System.in);   
System.out.print("Enter the number of rows: ");   
//taking row as input  
M = sc.nextInt();   

System.out.print("Enter the number of columns: ");   
//taking column as input  
N = sc.nextInt();   
 
int grid[][] = new int[M][N];     
System.out.println("Enter the elements of the array: ");
for (i = 0; i < M; i++)   

for (j = 0; j < N; j++)   
grid[i][j] = sc.nextInt();   

        // Displaying the grid
        System.out.println("Original Generation");
        for (i = 0; i < M; i++)
        {
            for (j = 0; j < N; j++)
            {
                if (grid[i][j] == 0)
                    System.out.print("#");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        nextGeneration(grid, M, N);
    }
  
    // Function to print next generation
    static void nextGeneration(int grid[][], int M, int N)
    {
        int[][] future = new int[M][N];
  
        // Loop through every cell
        for (int l = 1; l < M - 1; l++)
        {
            for (int m = 1; m < N - 1; m++)
            {
                // finding no Of Neighbours that are alive
                int aliveNeighbours = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        aliveNeighbours += grid[l + i][m + j];
  
                // The cell needs to be subtracted from
                // its neighbours as it was counted before
                aliveNeighbours -= grid[l][m];
  
                // Implementing the Rules of Life
  
                // Cell is lonely and dies
                if ((grid[l][m] == 1) && (aliveNeighbours < 2))
                    future[l][m] = 0;
  
                // Cell dies due to over population
                else if ((grid[l][m] == 1) && (aliveNeighbours > 3))
                    future[l][m] = 0;
  
                // A new cell is born
                else if ((grid[l][m] == 0) && (aliveNeighbours == 3))
                    future[l][m] = 1;
  
                // Remains the same
                else
                    future[l][m] = grid[l][m];
            }
        }
  
        System.out.println("Next Generation");
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (future[i][j] == 0)
                    System.out.print("#");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
    }
}


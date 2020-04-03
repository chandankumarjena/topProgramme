package topProgram;

public class IlandCount {

	  int ROW = 5;
	  int COL = 5;

	  public int countIslands(int mat[][]) {
	    boolean visited[][] = new boolean[ROW][COL];

	    int count = 0;

	    for (int i = 0; i < ROW; i++) {
	      for (int j = 0; j < COL; j++) {
	        if (mat[i][j] == 1 && !visited[i][j]) {
	          dfs(mat, i, j, visited);
	          count++;
	        }
	      }
	    }
	    
	    for (int i = 0; i < ROW; i++) {
		      for (int j = 0; j < COL; j++) {
		        System.out.print(visited[i][j] +" ");
		      }
		      System.out.println();
		    }
	    

	    return count;
	  }

	  private void dfs(int mat[][], int x, int y, boolean[][] visited) {
	    visited[x][y] = true;

	    if (ifSafe(mat, x - 1, y - 1, visited)) {
	      dfs(mat, x - 1, y - 1, visited);
	    }
	    
	    if (ifSafe(mat, x - 1, y, visited)) {
	      dfs(mat, x - 1, y, visited);
	    }
	    
	    if (ifSafe(mat, x - 1, y + 1, visited)) {
	      dfs(mat, x - 1, y + 1, visited);
	    }
	    
	    if (ifSafe(mat, x, y - 1, visited)) {
	      dfs(mat, x, y - 1, visited);
	    }
	    
	    if (ifSafe(mat, x, y + 1, visited)) {
	      dfs(mat, x, y + 1, visited);
	    }
	    
	    if (ifSafe(mat, x + 1, y - 1, visited)) {
	      dfs(mat, x + 1, y - 1, visited);
	    }
	    
	    if (ifSafe(mat, x + 1, y, visited)) {
	      dfs(mat, x + 1, y, visited);
	    }
	    
	    if (ifSafe(mat, x + 1, y + 1, visited)) {
	      dfs(mat, x + 1, y + 1, visited);
	    }
	    
	  }

	  private boolean ifSafe(int mat[][], int x, int y, boolean[][] visited) {
	    return x >= 0 && x < ROW
	        && y >= 0 && y < COL
	        && mat[x][y] == 1
	        && !visited[x][y];
	  }

	  public static void main(String[] args) {

		  //commited
	    IlandCount a = new IlandCount();

	    int[][] mat = { 
	        { 0, 1, 0, 0, 1 },
	        { 1, 0, 0, 0, 0 },
	        { 1, 0, 0, 1, 1 },
	        { 0, 0, 0, 0, 0 },
	        { 1, 0, 0, 0, 1 } };

	    System.out.println(a.countIslands(mat));
	  }
	}
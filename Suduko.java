package suduko;


public class Suduko 
{	
	
	public static boolean solve(int[][] sudoku) {
	  return new SudukoSolution(sudoku).solve();	
	}
	
	
	public static String asString(int[][] sudoku) {
	  return new Boards(sudoku).toString();	
	}
}

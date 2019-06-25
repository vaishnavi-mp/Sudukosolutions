package suduko;
import java.util.HashSet;
import java.util.Set;

import suduko.Suduko;

public class SudukoMain {
	public static void main(String[] args) {
		
		final int[][] sudoku = {
			{5,3,0,0,7,0,0,0,0},
			{0,0,0,1,0,0,0,4,8},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,6,0,4,0,0},	
			{0,2,0,0,0,0,0,0,0},
			{0,0,3,9,0,0,0,0,6},
			{0,0,0,0,0,0,0,0,0},
			{0,8,0,0,0,0,6,0,0},
			{0,0,5,2,0,6,0,0,0}
		};
		
		System.out.println(Suduko.asString(sudoku));
		// solution valid
		if (Suduko.solve(sudoku)) {
			System.out.println(Suduko.asString(sudoku));
		}
		System.out.println("Checking whether suduko solution is valid now.The result is ::");
		System.out.println(new SudukoMain().isValidSudoku(sudoku));
	}
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public boolean isValidSudoku(int[][] board) {
			if (board.length == 0 || board[0].length == 0)
				return false;
			// checking rows
			Set duplicates = new HashSet<>();
			for (int i = 0; i < board.length; i++) {
				duplicates = new HashSet();
				for (int j = 0; j < board[0].length; j++) {
					if (board[i][j] == '.')
						continue;
					if (duplicates.contains(board[i][j]))
						return false;
					duplicates.add(board[i][j]);
				}
			}

			// checking columns
			for (int i = 0; i < board.length; i++) {
				duplicates = new HashSet();
				for (int j = 0; j < board.length; j++) {
					if (board[j][i] == '.')
						continue;
					if (duplicates.contains(board[j][i]))
						return false;
					duplicates.add(board[j][i]);
				}
			}

			for (int i = 0; i <= board.length - 3; i = i + 3) {
				for (int j = 0; j <= board[0].length - 3; j = j + 3) {
					if (!check(i, i + 3, j, j + 3, board)) {
						return false;
					}
				}
			}
			return true;
		}

		@SuppressWarnings("unchecked")
		private boolean check(int i, int i1, int j, int j1, int[][] board) {
			@SuppressWarnings("rawtypes")
			Set duplicates = new HashSet();
			for (int r = i; r < i1; r++) {
				for (int c = j; c < j1; c++) {
					if (board[r][c] == '.')
						continue;
					if(duplicates.contains(board[r][c])) {
						return false;
					}
					duplicates.add(board[r][c]);
				}
			}
			return true;
		}		
		
	}




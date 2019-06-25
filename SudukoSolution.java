package suduko;
import static suduko.Boards.EMPTY;
import static suduko.Boards.SIZE;


class SudukoSolution {

	private final Boards board;

	SudukoSolution(int[][] input) {
		this.board = new Boards(input);
	}
	
	boolean solve() {
		return solve(0,0);
	}

	
	Boards getBoard() {
		return board;
	}
	
	
	private boolean solve(int row, int col) {
		if (row == SIZE) {
			row = 0;
			if (++col == SIZE) {
				return true;
			}
		}
		if (board.getCell(row, col) != EMPTY) {
			return solve(row+1,col);
		}
		
		for(int val = 1; val <= SIZE; val++) {
			if (isMoveOK(row, col, val)) {
				board.setCell(row, col, val);
				if (solve(row+1, col)) {
					return true;
				}
			}
		}
		
		board.setCell(row, col, EMPTY);
		return false;
	}


	private boolean isMoveOK(int row, int col, int val) {
		return ! (  arrayContains(board.getRow(row), val)
				|| arrayContains(board.getColumn(col), val)
				|| arrayContains(board.getRegion(row, col), val));
	}

	private boolean arrayContains(int[] array, int val) {
		for (int arrayVal : array) {
			if (arrayVal == val) {
				// return true and stop the iteration
				return true;
			}
		}
		return false;
	}
}
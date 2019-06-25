package suduko;

import java.util.Arrays;


final class Boards {
	//final variables caps
	static final int EMPTY = 0;
	static final int SIZE = 9;
	static final int REGION = 3;
	static final String ERROR_MSG = "Please provide a "+ SIZE +"x" + SIZE + " array for Input";

	private final int[][] boards;
	private char[] line;

	
	Boards(int[][] init) {
		
		boards = init;
	}
	
	int[] getRow(int row) {
		return boards[row];
	}

	
	int[] getColumn(int col) {
		final int[] columnView = new int[SIZE];
		for(int a = 0; a < SIZE; a++) {
			columnView[a] = boards[a][col];
		}
		return columnView;
	}

	
	int[] getRegion(int row, int col) {
		final int[] regionView = new int[SIZE];
		final int rowBase = row - (row % REGION);
		final int colBase = col - (col % REGION);
		int counter = 0;
		
		for (int r = rowBase; r < REGION + rowBase; r++) {
			for (int c = colBase ; c < REGION + colBase; c++) {
				regionView[counter++] = boards[r][c];
			}
		}
		return regionView;
	}

	
	int getCell(int row, int col) {
		return boards[row][col];
	}

	
	void setCell(int row, int col, int val) {
		boards[row][col] = val;
	}

	
	@Override
	public String toString() {
		
		final int size = (SIZE*2+1+((REGION+1)*2))*(SIZE+REGION+1);
		final String verticalSpace = " |";
		
		final StringBuilder builder = new StringBuilder(size);
		
		for (int a=0; a < SIZE; a++) {
			int[] row = boards[a];
			if (a % REGION == 0) {
				appendLine(builder);
			}
			for (int b=0; b < SIZE; b++) {
				int value = row[b];
				if (b % REGION == 0) {
					builder.append(verticalSpace);
				}
				appendValue(builder, value);
			}
			builder.append(verticalSpace);
			builder.append('\n');
		}
		appendLine(builder);
		return builder.toString();
	}

	
	private void appendValue(StringBuilder builder, int value) {
		builder.append(' ');
		if (value != EMPTY) {
			builder.append(value);
		} else {
			builder.append('_');
		}
	}
	
	private void appendLine(StringBuilder builder) {
		
		if (line == null) {
		  line = new char[SIZE*2+((REGION+1)*2)];
		  Arrays.fill(line, '-');
		  
		  line[0] = ' ';
		}
		builder.append(line);
		builder.append('\n');
	}
}

package Main;

import java.io.*;

/**
 * Solve Sudoku as a graph coloring problem using Neo4j
 *
 * @author Stefan Plantikow <stefan.plantikow@googlemail.com>
 *
 */
public class Sudoku {

    private int[][] board;
    private int answer = 0;

    public Sudoku(int board[][]) throws IOException {
        this.board = board;
    }

    private static int hard = 25;

    public boolean start(){
        return  solve(0, 0, board);
    }
    
   public boolean solve(int x, int y, int[][] cells) { // 回溯算法求解数独
		if (x == 9) {
			x = 0;
			if (++y == 9) {     // 递归的出口
				this.answer++;
                                showBoard();
				return true;
			}
		}
		
		if (cells[x][y] != 0) { //si es una celda vacia
			return solve(x + 1, y, cells);//continue con la siguiente celda
		}
		
		for (int val = 1; val <= 9; ++val) {
			cells[x][y] = val;
			if (legal(x, y, val, cells)) {
				solve(x+1, y, cells);
			}
		}
		cells[x][y] = 0;	// 如果没有找到解，要重置该位，并回溯
		
		return false;
	}

	public static boolean legal(int x, int y, int val, int[][] cells) { // 回溯算法中的试错
		for (int i = 0; i < 9; ++i) {	// 检查行
			if (i != x && val == cells[i][y]) {
				return false;
			}
		}

		for (int i = 0; i < 9; ++i) {	// 检查列
			if (i != y && val == cells[x][i]) {
				return false;
			}
		}

		int boxRowOffset = (x / 3) * 3;
		int boxColOffset = (y / 3) * 3;
		
		// 检查9宫格
		for (int row = boxRowOffset; row < boxRowOffset+3; ++row) {
			for (int col = boxColOffset; col < boxColOffset+3; ++col) {
				if ((row != x || col != y) && val == cells[row][col]) {
					return false;
				}
			}
		}

		return true;
	}



    public void showBoard() {
        System.out.print(this.toString());
    }

    public int getAnswer() {
        return answer;
    }
    
    

    @Override
    public String toString() {
        String boardString = "";
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0) {
                boardString += "====================\n";
            }
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0) {
                    boardString += " | ";
                }
                boardString += this.board[i][j];
            }
            boardString += "|";
            boardString += "\n";
        }
        boardString += "====================\n";

        return boardString;
    }
    
    

}

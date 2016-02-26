package Main;

import java.io.*;
import java.util.Random;

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

    public boolean start() {
        return solve(0, 0, board);
    }

    public boolean resolve() {
        Random random = new Random();
        int cellEmpty = 0;//número de celdas vacias
        int cellEmptyLast = 9999;//numero de celdas en el último ciclo
        int cellFilled = this.cellsFilled();
        boolean success = false;
        int value = 0;
        while (!success) {
            System.out.println("Celdas asignadas: " + cellFilled);
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (this.board[i][j] == 0) {//si la celda no está asignada
                        value = random();
                        if (isLegal(i, j, value)) {// si el valor no se encontro en fila, columna y cuadricula es legal
                            this.board[i][j] = value;//se asigna el valor
                            cellFilled++;
                        } else {
                            cellEmpty++;//aumente el valor de celdas vacias
                        }
                    } 
                }
            }
            if (cellFilled == 81) {//si no hay celdas vacías
                success = true;//se llenaron todas las casillas
            } else {
//                if (cellEmpty == cellEmptyLast) {// si las celdas vacías son las mismas que el anterior ciclo
//                    break;//existe un bloquero irreversible, fracaso el algoritmo, no hay solución
//                }
                //sino, realice un ciclo más
                cellEmptyLast = cellEmpty;
                cellEmpty = 0;
            }

        }
        return success;
    }
    
    public int cellsFilled (){
        int cellsFilled = 0;
        for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (this.board[i][j] != 0) {//si la celda no está asignada
                        cellsFilled++;
                    } 
                }
            }
        return cellsFilled;
    }

    public static int random() {
        Random random = new Random();
        return 1 + Math.abs((random.nextInt() % 9));
    }

    /**
     * Determina si es legal que en una celda se coloque un número determinado,
     * para esto realiza la respectiva búsqueda en toda la fila, la columna y la
     * cuadricula(miniboard)
     */
    public boolean isLegal(int row, int col, int value) {

        //verifica si en la fila existe el valor
        for (int j = 0; j < 9; j++) {
            if (this.board[row][j] == value) {
                return false;
            }
        }
        //verifica si en la columna existe el valor
        for (int i = 0; i < 9; i++) {
            if (this.board[i][col] == value) {
                return false;
            }
        }

        //verifica si en la cuadricula existe el valor
        //  (row|col / 3) * 3 = formula para hallar el comienzo de fila y/o columna (división entera trunca el número)
        int I = (row / 3) * 3;
        int J = (col / 3) * 3;
        for (int i = I; i < (I + 3); i++) {
            for (int j = J; j < (J + 3); j++) {
                if (this.board[i][j] == value) {
                    return false;
                }
            }
        }

        return true; //el valor no existe en fila, columna y fila, entonces es legal asignarlo
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
                solve(x + 1, y, cells);
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
        for (int row = boxRowOffset; row < boxRowOffset + 3; ++row) {
            for (int col = boxColOffset; col < boxColOffset + 3; ++col) {
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

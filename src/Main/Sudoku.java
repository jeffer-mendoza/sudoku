package Main;

import java.io.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Solve Sudoku as a graph coloring problem using Neo4j
 *
 * @author Stefan Plantikow <stefan.plantikow@googlemail.com>
 */
public class Sudoku {

    private int[][] board;
    private int answer = 0;
    private Random random;

    public Sudoku(int board[][]) {
        this.board = board;
        Date d = new Date();
    }

    

    public boolean resolve(int iteracion) {
        Random random = new Random();
        int numerosFaltantes[];
        int cellEmpty = 0;//número de celdas vacias
        int cellEmptyLast = 9999;//numero de celdas en el último ciclo
        int cellFilled = this.cellsFilled();//obtener el número de celdas que ya están asignadas
        boolean success = false;
        int value = 0;
        cellFilled = this.cellsFilled();
        cellEmpty = 81 - cellFilled;
        success = false;
        while (true) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (this.board[i][j] == 0) {
                        //si la celda no está asignada
                        numerosFaltantes = this.NumerosFaltan(i, j);
                        if (numerosFaltantes.length > 0) {
                            value = this.generarRandom(numerosFaltantes);
                            if (isLegal(i, j, value)) {// si el valor no se encontro en fila, columna y cuadricula es legal
                                this.board[i][j] = value;//se asigna el valor
                                cellFilled++;
                                cellEmpty--;
                                if (cellFilled == 81) {//si no hay celdas vacías
                                    System.out.println(iteracion + ";" + cellFilled + ";" + cellEmpty + ";exito");
                                    this.showBoard();
                                    return true;
                                }
                            }
                        } else {
                            System.out.println(iteracion + ";" + cellFilled + ";" + cellEmpty + ";fracaso");
                            this.showBoard();
                            return false;
                        }
                    }
                }
            }

        }
    }

    public int cellsFilled() {
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

    public int generarRandom(int rango[]) {
        random = new java.util.Random();
        int a = Math.abs((this.random.nextInt() % rango.length));
        return rango[a];
    }

    /**
     * Determina si es legal que en una celda se coloque un número determinado,
     * para esto realiza la respectiva búsqueda en toda la fila, la columna y la
     * cuadricula(miniboard)
     */
    public boolean isLegal(int row, int col, int value) {
        boolean rowCondition = true;
        boolean colCondition = true;
        boolean miniboardCondition = true;

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

    public int[] NumerosFaltan(int row, int col) {
        List<Integer> numeros = new LinkedList<>();
        numeros.add(new Integer(1));
        numeros.add(new Integer(2));
        numeros.add(new Integer(3));
        numeros.add(new Integer(4));
        numeros.add(new Integer(5));
        numeros.add(new Integer(6));
        numeros.add(new Integer(7));
        numeros.add(new Integer(8));
        numeros.add(new Integer(9));

        //verifica si en la fila existe el valor
        for (int j = 0; j < 9; j++) {
            numeros.remove(new Integer(this.board[row][j]));
        }
        //verifica si en la columna existe el valor
        for (int i = 0; i < 9; i++) {
            numeros.remove(new Integer(this.board[i][col]));
        }
        //verifica si en la cuadricula existe el valor
        //  (row|col / 3) * 3 = formula para hallar el comienzo de fila y/o columna (división entera trunca el número)
        int I = (row / 3) * 3;
        int J = (col / 3) * 3;
        for (int i = I; i < (I + 3); i++) {
            for (int j = J; j < (J + 3); j++) {
                numeros.remove(new Integer(this.board[i][j]));
            }
        }
        int resultado[] = new int[numeros.size()];
        for (int j = 0; j < numeros.size(); j++) {
            resultado[j] = numeros.get(j);
        }
        return resultado;

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

    public void setBoard(int[][] board) {
        this.board = board;
    }
    
    

}

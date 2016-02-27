/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jefferson Mendoza <jefferson.mendoza@correounivalle.edu.co>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {

            Sudoku sudoku = new Sudoku(Resource.readerFile("sudoku2.txt"));
            System.out.println("Init Board");
            sudoku.showBoard();
            long start = System.currentTimeMillis();
            boolean solved = sudoku.resolve();
            long end = System.currentTimeMillis();
            if (solved) {
                System.out.println("Tiempo de solución:" + (end - start) + " ms");
                sudoku.showBoard();
            } else {
                System.out.println("No solved");
                sudoku.showBoard();
            }

        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

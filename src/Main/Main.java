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
            int iteraciones = Integer.parseInt(args[1]);
            Sudoku sudoku = new Sudoku(Resource.readerFile(args[0]));
            System.out.println("Init Board");
            sudoku.showBoard();
            long start = System.currentTimeMillis();

            System.out.println("numeroIteracion;celdasLlenas;celdasVacias;estado");
            for (int iteracion = 0; iteracion < iteraciones; iteracion++) {
                sudoku.setBoard(Resource.readerFile(args[0]));
                sudoku.resolve(iteracion);
            }
            long end = System.currentTimeMillis();

            System.out.println(
                    "Tiempo de solución:" + (end - start) + " ms");

        } catch (IOException ex) {
            Logger.getLogger(Main.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

}

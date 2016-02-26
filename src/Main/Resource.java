/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author webmaster
 */
public class Resource {

    public static int[][] readerFile(String file) throws IOException {
        String line;
        String[] cells;
        int row = 0;
        int board[][] = new int[9][9];
        FileReader f = new FileReader(file);
        BufferedReader b = new BufferedReader(f);
        while ((line = b.readLine()) != null) {
            cells = line.split(" ");
            for (int col = 0; col < 9; col++) {
                board[row][col] = Integer.parseInt(cells[col]);
            }
            row++;
        }

        f.close();
        b.close();
        return board;
    }
}

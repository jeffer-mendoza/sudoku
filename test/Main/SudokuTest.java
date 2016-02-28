/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jeffer
 */
public class SudokuTest {
    
    public SudokuTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of start method, of class Sudoku.
     */
    public void testStart() {
        System.out.println("start");
        Sudoku instance = null;
        boolean expResult = false;
        boolean result = instance.start();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of resolve method, of class Sudoku.
     */
    public void testResolve() {
        System.out.println("resolve");
        Sudoku instance = null;
        boolean expResult = false;
        boolean result = instance.resolve();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cellsFilled method, of class Sudoku.
     */
    public void testCellsFilled() {
        System.out.println("cellsFilled");
        Sudoku instance = null;
        int expResult = 0;
        int result = instance.cellsFilled();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of random method, of class Sudoku.
     */
    public void testRandom() {
        System.out.println("random");
        int expResult = 0;
        int result = Sudoku.random();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of neighboring method, of class Sudoku.
     */
    @Test
    public void testNeighboring() throws IOException {
        System.out.println("neighboring");
        int board[][] = {
                {0, 2, 0, 6, 0, 0, 0, 0, 0},
                {0, 7, 6, 1, 0, 0, 9, 0, 0},
                {0, 0, 0, 7, 0, 0, 2, 0, 0},
                {8, 0, 0, 0, 0, 9, 0, 0, 4},
                {2, 1, 0, 0, 8, 3, 0, 0, 0},
                {4, 0, 0, 0, 0, 0, 0, 0, 7},
                {0, 0, 0, 0, 0, 0, 0, 6, 5},
                {0, 0, 4, 0, 6, 7, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 3, 0}};
        int row = 2;
        int col = 8;
        int value = 6;
        Sudoku instance = new Sudoku(board);
        boolean expResult = true;
        boolean result = instance.neighboring(row, col, value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of isLegal method, of class Sudoku.
     */
    public void testIsLegal() {
        System.out.println("isLegal");
        int row = 0;
        int col = 0;
        int value = 0;
        Sudoku instance = null;
        boolean expResult = false;
        boolean result = instance.isLegal(row, col, value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of solve method, of class Sudoku.
     */
    public void testSolve() {
        System.out.println("solve");
        int x = 0;
        int y = 0;
        int[][] cells = null;
        Sudoku instance = null;
        boolean expResult = false;
        boolean result = instance.solve(x, y, cells);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of legal method, of class Sudoku.
     */
    public void testLegal() {
        System.out.println("legal");
        int x = 0;
        int y = 0;
        int val = 0;
        int[][] cells = null;
        boolean expResult = false;
        boolean result = Sudoku.legal(x, y, val, cells);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showBoard method, of class Sudoku.
     */
    public void testShowBoard() {
        System.out.println("showBoard");
        Sudoku instance = null;
        instance.showBoard();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAnswer method, of class Sudoku.
     */
    public void testGetAnswer() {
        System.out.println("getAnswer");
        Sudoku instance = null;
        int expResult = 0;
        int result = instance.getAnswer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Sudoku.
     */
    public void testToString() {
        System.out.println("toString");
        Sudoku instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

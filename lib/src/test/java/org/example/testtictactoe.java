package org.example;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testtictactoe {
    
    @BeforeEach
    void setUp() {

        tictactoe.board = new char[][]{{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}};
        tictactoe.player = 'X';
    }

    @Test    
    void testrowwin() {
        tictactoe.move(1);
        tictactoe.move(4);
        tictactoe.move(2);
        tictactoe.move(5);
        tictactoe.move(3);
        assertTrue(tictactoe.win());
    }

    @Test
    void testcolumnwin() {
        tictactoe.move(1);
        tictactoe.move(2);
        tictactoe.move(4);
        tictactoe.move(5);
        tictactoe.move(7);
        assertTrue(tictactoe.win());
    }

    @Test
    void testdiagonalwin() {
        tictactoe.move(1);
        tictactoe.move(2);
        tictactoe.move(5);
        tictactoe.move(3);
        tictactoe.move(9);
        assertTrue(tictactoe.win());
    }
    
    @Test
    void testdraw() {
        tictactoe.move(1);
        tictactoe.move(2);
        tictactoe.move(3);
        tictactoe.move(4);
        tictactoe.move(5);
        tictactoe.move(6);
        tictactoe.move(7);
        tictactoe.move(8);
        tictactoe.move(9);
        assertTrue(tictactoe.draw());
    }
    
    @Test
    void testcomputerturn() {
        tictactoe.move(1);
        tictactoe.computerturn();
        assertNotEquals('1', tictactoe.board[0][0]);
    }
    
    @Test
    public void testexit() {
        boolean result = tictactoe.exitmenu(new Scanner("y"));
        assertTrue(result);
    }

    @Test
    public void testplayagain() {
        boolean result = tictactoe.exitmenu(new Scanner("n"));
        assertFalse(result);
    }

    @Test
    public void testMainMenuPlayerVsComputer() {
        int choice = tictactoe.mainmenu(new Scanner("2"));
        assertEquals(2, choice);
    }
}

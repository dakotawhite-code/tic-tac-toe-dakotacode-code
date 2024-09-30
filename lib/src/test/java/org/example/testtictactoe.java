package org.example;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testtictactoe {
    private tictactoe tictactoe;

    @BeforeEach
    void setUp() {
        tictactoe = new tictactoe();
    }

    @Test
    void testrow() {
        tictactoe.move(1);
        tictactoe.move(4);
        tictactoe.move(2);
        tictactoe.move(5);
        tictactoe.move(3);
        assertTrue(tictactoe.win());
    }

    @Test
    void testcolumn() {
        tictactoe.move(1);
        tictactoe.move(2);
        tictactoe.move(4);
        tictactoe.move(5);
        tictactoe.move(7);
        assertTrue(tictactoe.win());
    }

    @Test
    void testdiagonal() {
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
}

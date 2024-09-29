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
        tictactoe.move(1); // X
        tictactoe.move(2); // O
        tictactoe.move(4); // X
        tictactoe.move(5); // O
        tictactoe.move(7); // X
        assertTrue(tictactoe.win()); // X should win
    }

    @Test
    void testdiagonal() {
        tictactoe.move(1); // X
        tictactoe.move(2); // O
        tictactoe.move(5); // X
        tictactoe.move(3); // O
        tictactoe.move(9); // X
        assertTrue(tictactoe.win()); // X should win diagonally
    }

    @Test
    void testdraw() {
        tictactoe.move(1); // X
        tictactoe.move(2); // O
        tictactoe.move(3); // X
        tictactoe.move(4); // O
        tictactoe.move(5); // X
        tictactoe.move(6); // O
        tictactoe.move(7); // X
        tictactoe.move(8); // O
        tictactoe.move(9); // X
        assertTrue(tictactoe.draw()); // The tictactoe should end in a draw
    }
}

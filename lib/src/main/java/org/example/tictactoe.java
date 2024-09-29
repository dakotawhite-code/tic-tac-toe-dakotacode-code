package org.example;

import java.util.Scanner;

public class tictactoe {
    public static char[][] board = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };
    public static char player = 'X';

    public static boolean validspace(int input) {
        switch (input) {
            case 1: return board[0][0] == ' ';
            case 2: return board[0][1] == ' ';
            case 3: return board[0][2] == ' ';
            case 4: return board[1][0] == ' ';
            case 5: return board[1][1] == ' ';
            case 6: return board[1][2] == ' ';
            case 7: return board[2][0] == ' ';
            case 8: return board[2][1] == ' ';
            case 9: return board[2][2] == ' ';
            default: return false;
        }
    }

    public static void turn(Scanner scan) {
        int input;
        while (true) {
            System.out.print("Player " + player + ", enter your move (1-9): ");
            if (scan.hasNextInt()) {
                input = scan.nextInt();
                if (validspace(input)) {
                    move(input);
                    break;
                } else {
                    System.out.println("That move is invalid! Try again.");
                }
            } else {
                System.out.println("Invalid input! Please enter a number between 1 and 9.");
                scan.next();
            }
        }
    }

    public static void move(int input) {
        switch (input) {
            case 1: board[0][0] = player; break;
            case 2: board[0][1] = player; break;
            case 3: board[0][2] = player; break;
            case 4: board[1][0] = player; break;
            case 5: board[1][1] = player; break;
            case 6: board[1][2] = player; break;
            case 7: board[2][0] = player; break;
            case 8: board[2][1] = player; break;
            case 9: board[2][2] = player; break;
        }
    }

    public static void printBoard() {
        System.out.println(board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
        System.out.println("--+---+--");
        System.out.println(board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
        System.out.println("--+---+--");
        System.out.println(board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
    }

    public static boolean win() {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
               (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    public static boolean draw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            printBoard();
            turn(scan);
            if (win()) {
                printBoard();
                System.out.println("Player " + player + " wins!");
                break;
            }
            if (draw()) {
                printBoard();
                System.out.println("It's a draw!");
                break;
            }
            player = (player == 'X') ? 'O' : 'X';
        }
        scan.close();
    }
}

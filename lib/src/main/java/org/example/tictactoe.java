package org.example;

import java.util.Random;
import java.util.Scanner;

public class tictactoe {
    public static char[][] board = {
        {'1', '2', '3'},
        {'4', '5', '6'},
        {'7', '8', '9'}
    };
    public static char player = 'X';
    public static Random random = new Random();
    public static char p1mark;
    public static char p2mark;

    public static char custom(Scanner scan, String player) {
        char mark;
        while (true) {
            System.out.print("Enter custom mark (single character) for " + player + ": ");
            String input = scan.nextLine();
            
            if (input.length() == 1) {
                mark = input.charAt(0);
                if (!Character.isWhitespace(mark)) {
                    return mark;
                } else {
                    System.out.println("Whitespace is not allowed as a mark. Please enter a valid character.");
                }
            } else {
                System.out.println("Invalid input! Please enter exactly one character.");
            }
        }
    }

    public static boolean validspace(int input) {
        return switch (input) {
            case 1 -> board[0][0] == '1';
            case 2 -> board[0][1] == '2';
            case 3 -> board[0][2] == '3';
            case 4 -> board[1][0] == '4';
            case 5 -> board[1][1] == '5';
            case 6 -> board[1][2] == '6';
            case 7 -> board[2][0] == '7';
            case 8 -> board[2][1] == '8';
            case 9 -> board[2][2] == '9';
            default -> false;
        };
    }

    public static void turn(Scanner scan) {
        int input;
        boolean error = false;
        while (true) {
            System.out.print("Player " + player + ", enter your move (1-9): ");
    
            if (scan.hasNextInt()) {
                input = scan.nextInt();
                if (validspace(input)) {
                    move(input);
                    break;
                } else {
                    System.out.println("That move is invalid! Try again.");
                    error = false;
                }
            } else {
                if (!error) {
                    System.out.println("Invalid input! Please enter a number between 1 and 9.");
                    error = true;
                }
                scan.nextLine();
            }
        }
    }

    public static void move(int input) {
        switch (input) {
            case 1 -> board[0][0] = player;
            case 2 -> board[0][1] = player;
            case 3 -> board[0][2] = player;
            case 4 -> board[1][0] = player;
            case 5 -> board[1][1] = player;
            case 6 -> board[1][2] = player;
            case 7 -> board[2][0] = player;
            case 8 -> board[2][1] = player;
            case 9 -> board[2][2] = player;
        }
    }

    public static void printBoard() {
        System.out.println(" " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " ");
        System.out.println("---+---+---");
        System.out.println(" " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " ");
        System.out.println("---+---+---");
        System.out.println(" " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " ");
        System.out.println();
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
                if (board[i][j] == '1' || board[i][j] == '2' || board[i][j] == '3' ||
                    board[i][j] == '4' || board[i][j] == '5' || board[i][j] == '6' ||
                    board[i][j] == '7' || board[i][j] == '8' || board[i][j] == '9') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void computerturn() {
        int input;
        input = random.nextInt(9) + 1;
        if (validspace(input)){
            move(input);
            System.out.println("Computer placed " + player + " in position " + input);
        } else {
            computerturn();
        }
    }

    public static boolean exitmenu(Scanner scan) {
        System.out.print("Do you want to play against your current opponent again? (y/n): ");
        String response = scan.nextLine().toLowerCase();
        switch (response) {
            case "y" -> { System.out.println("Let's do it.");
                return true; }
            case "n" -> { System.out.println("Thank you for playing.");
                return false; }
            default -> { System.out.println("Invalid input! Please enter 'y' for yes or 'n' for no.");
                return exitmenu(scan);
            }
        }
    }
    
    public static int mainmenu(Scanner scan) {
        System.out.println("Let's play Tic-Tac-Toe\n\nPlease select your opponent:");
        System.out.println("1. Player vs Player\n2. Player vs Computer");
        System.out.print("Who would you like to play? (Enter 1 or 2): ");
    
        if (scan.hasNextInt()) {
            int choice = scan.nextInt();
            switch (choice) {
                case 1 -> { System.out.println("Playing against Player Opponent...");
                    return choice;
                }
                case 2 -> { System.out.println("Playing against Computer Opponent...");
                    return choice;
                }
                default -> System.out.println("Invalid choice! Please enter 1 or 2.");
            }
        } else {
            System.out.println("Invalid input! Please enter a number.");
            scan.nextLine();
        }
        return mainmenu(scan);
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean playing = true;
        int choice = mainmenu(scan);

        ////////////////////////
        scan.nextLine();
        p1mark = custom(scan, "Player 1");
        p2mark = custom(scan, "Player 2");

    
        while (playing) {
            board = new char[][]{{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}};
            player = p1mark;
            boolean isComputer = (choice == 2);
    
            while (true) {
                printBoard();
                if (isComputer && player == p2mark) {
                    computerturn();
                } else {
                    turn(scan);
                }
    
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
                player = (player == p1mark) ? p2mark : p1mark;
            }
            scan.nextLine();
            playing = exitmenu(scan);
        }
        scan.close();
    }
}
import java.util.*;

public class TicTacToe {
    private int[][] board;
    private int turn;
    public TicTacToe() {
        this.board = new int[3][3];
        this.turn = 1;
    }
    public void inputMove(int x, int y) {
        if (x > 2 || y > 2) {
            System.out.println("Move not valid.");
            return;
        }
        this.board[x][y] = this.turn;
        if (hasWon()) {
            System.out.println("This Player has Won!");
        }
        if (this.turn == 1) {
            this.turn = -1;
        } else {
            this.turn = 1;
        }
    }
    public Boolean hasWon() {
        for (int i = 0; i < 3; i++) {
            if (checkDirection(i, 0, 1, 0)) {
                return true;
            }
            if (checkDirection(0, i, 0, 1)) {
                return true;
            }
        }
        if (checkDirection(0, 0, 1, 1)) {
            return true;
        }
        if (checkDirection(0, 2, 1, -1)) {
            return true;
        }
        return false;
    }

    public Boolean checkDirection(int x, int y, int delX, int delY) {
        while (x < 3 && y < 3) {
            if (this.board[x][y] != this.turn) {
                return false;
            }
            x += delX;
            y += delY;
        }
        return true;
    }
    public static void main(String[] args) {
        TicTacToe t = new TicTacToe();
        t.inputMove(0, 0);
        t.inputMove(0, 1);
        t.inputMove(1, 1);
        t.inputMove(1, 0);
        t.inputMove(2, 2);
    }
}
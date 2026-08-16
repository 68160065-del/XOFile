/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.xogui;

/**
 *
 * @author admin
 */
public class Board {
    private char[][] table = {{'-', '-', '-'}, {'-', '-', '-'}, {'-', '-', '-'},};
    private Player currentPlayer;
    private Player O, X;

    public Board(Player O, Player X) {
        this.O = O;
        this.X = X;
        this.currentPlayer = O;
    }

    public char[][] getTable() {
        return table;
    }

    public void setTable(char[][] table) {
        this.table = table;
    }

    public boolean setRowCol(int row, int col) {
        if (this.table[row - 1][col - 1] != '-') {
            return false;
        }
        this.table[row - 1][col - 1] = currentPlayer.getName();
        return true;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    void switchPlayer() {
        if (this.currentPlayer == O) {
            this.currentPlayer = X;
        } else {
            this.currentPlayer = O;
        }
    }

    public boolean checkWin() {

        for (int i = 0; i < 3; i++) {
            if (table[i][0] != '-' && table[i][0] == table[i][1] && table[i][1] == table[i][2]) {
                return true;
            }
            if (table[0][i] != '-' && table[0][i] == table[1][i] && table[1][i] == table[2][i]) {
                return true;
            }
        }
        if (table[0][0] != '-' && table[0][0] == table[1][1] && table[1][1] == table[2][2]) {
            return true;
        }
        if (table[0][2] != '-' && table[0][2] == table[1][1] && table[1][1] == table[2][0]) {
            return true;
        }
        return false;
    }

    boolean checkDraw() {
        if (checkWin()) {
            return false;
        }
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (table[r][c] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}

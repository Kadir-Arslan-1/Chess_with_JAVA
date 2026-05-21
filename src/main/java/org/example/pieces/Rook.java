package org.example.pieces;

import org.example.ChessPiece;

public class Rook extends ChessPiece {

    public Rook(my_color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(String newPosition) {
        char currentColumn = position.charAt(0);
        int currentRow = Integer.parseInt(String.valueOf(position.charAt(1)));

        char newColumn = newPosition.charAt(0);
        int newRow = Integer.parseInt(String.valueOf(newPosition.charAt(1)));

        int colDiff = Math.abs(currentColumn - newColumn);
        int rowDiff = Math.abs(currentRow - newRow);

        // A rook moves straight along a column or a row.
        // It must move at least one square.
        if ((colDiff == 0 && rowDiff > 0) || (rowDiff == 0 && colDiff > 0)) {
            return true;
        }

        return false;
    }
}
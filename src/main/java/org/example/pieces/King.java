package org.example.pieces;

import org.example.ChessPiece;

public class King extends ChessPiece {

    public King(my_color color) {
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

        // A king moves exactly 1 square in any direction.
        // It cannot stay in the exact same spot.
        if (colDiff <= 1 && rowDiff <= 1 && !(colDiff == 0 && rowDiff == 0)) {
            return true;
        }

        return false;
    }
}
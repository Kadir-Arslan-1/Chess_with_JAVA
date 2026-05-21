package org.example.pieces;

import org.example.ChessPiece;

public class Knight extends ChessPiece {

    public Knight(my_color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(String newPosition) {
        char currentColumn = position.charAt(0);
        int currentRow = Integer.parseInt(String.valueOf(position.charAt(1)));

        char newColumn = newPosition.charAt(0);
        int newRow = Integer.parseInt(String.valueOf(newPosition.charAt(1)));

        if (currentColumn == newColumn -1 || currentColumn == newColumn + 1 ) {
            if (this.color.equals(my_color.White) && newRow == currentRow + 2) {
                return true;
            } else if (color.equals(my_color.Black) && newRow == currentRow - 2) {
                return true;
            }

        }

        else if (Math.abs(currentColumn-newColumn) == 2 && Math.abs(currentRow-newRow)==1){
            return true;
        }

        return false;
    }
}

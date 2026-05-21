package org.example.pieces;

import org.example.ChessPiece;

public class Pawn extends ChessPiece {

    public Pawn(my_color color){
        super(color);
    }

    @Override
    public boolean isValidMove(String newPosition) {
        char currentColumn = position.charAt(0);
        int currentRow = Integer.parseInt(String.valueOf(position.charAt(1)));

        char newColumn = newPosition.charAt(0);
        int newRow = Integer.parseInt(String.valueOf(newPosition.charAt(1)));


        if (currentColumn == newColumn) {
            if (color.equals(my_color.White) && newRow == currentRow + 1) {
                return true;
            } else if (color.equals(my_color.Black) && newRow == currentRow - 1) {
                return true;
            }
        }
        return false;
    }


    public boolean isFirstValidMove(String newPosition) {
        char currentColumn = position.charAt(0);
        int currentRow = Integer.parseInt(String.valueOf(position.charAt(1)));

        char newColumn = newPosition.charAt(0);
        int newRow = Integer.parseInt(String.valueOf(newPosition.charAt(1)));


        if (currentColumn == newColumn) {
            if (color.equals(my_color.White) && currentRow == 2 && newRow == currentRow + 2) {
                return true;
            } else if (color.equals(my_color.Black) && currentRow ==7 && newRow == currentRow -2) {
                return true;
            }
        }
        return false;
    }


}

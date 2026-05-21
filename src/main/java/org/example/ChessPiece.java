package org.example;

public abstract class ChessPiece {

    protected my_color color; // "white" or "black"
    protected String position; // e.g., "a2"

    public ChessPiece(my_color color) {
        this.color = color;
    }
    public my_color getColor() {
        return color;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }

    // Abstract method to be implemented by specific pieces like Pawn, Knight, etc.
    public abstract boolean isValidMove(String newPosition);

    public enum my_color {
        Black,
        White;
    }
}

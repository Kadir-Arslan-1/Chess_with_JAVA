package org.example;

import org.example.exceptions.FriendlyPieceException;
import org.example.pieces.Pawn;

import java.util.ArrayList;
import java.util.Optional;
import static org.example.conversions.LetterPosition.getLetterPosition;
import static org.example.conversions.LetterConversion.convert;


public class ChessBoard {
    public Optional<ChessPiece>[][] internalBoard = new Optional[8][8];
    public ArrayList<ChessPiece> externalBoard = new ArrayList<>();

    public ChessBoard() {
        // Initialize the board with Optional.empty() for all cells
        for (int i = 0; i < internalBoard.length; i++) {
            for (int j = 0; j < internalBoard[i].length; j++) {
                internalBoard[i][j] = Optional.empty();
            }
        }
    }

    private boolean isValidPosition(String position) {
        return position.matches("^[a-h][1-8]$"); // Validates positions like a1, h8, etc.
    }

    public boolean addPiece(ChessPiece piece, String position) {
        int[] indices = getPositionIndices(position);

        if (indices != null && internalBoard[indices[0]][indices[1]].isEmpty()) {
            piece.setPosition(position);
            internalBoard[indices[0]][indices[1]] = Optional.of(piece);
            return true;
        }
        return false;
    }

    public Optional<ChessPiece> getPieceAt(String position) {
        int[] indices = getPositionIndices(position);
        if (indices != null) {
            return internalBoard[indices[0]][indices[1]];
        }
        return Optional.empty();
    }

    private int[] getPositionIndices(String position) {
        if (!isValidPosition(position)) {
            return null;
        }
        char firstLetter = position.toLowerCase().charAt(0);
        int firstLetterPosition = getLetterPosition(firstLetter) - 1;

        int secondLetter = Integer.parseInt(String.valueOf(position.charAt(1)));
        int secondLetterPosition = convert(secondLetter);

        return new int[]{firstLetterPosition, secondLetterPosition};
    }

    public boolean positionCheck(ChessPiece piece, String newPosition) throws FriendlyPieceException {
        int[] oldIndices = getPositionIndices(piece.getPosition());
        int[] newIndices = getPositionIndices(newPosition);

        Optional<ChessPiece> pieceAtNewPosition = getPieceAt(newPosition);

        if (pieceAtNewPosition.isPresent() && piece.getColor().equals(pieceAtNewPosition.get().getColor())) {
            throw new FriendlyPieceException("Cannot move to a position occupied by a friendly piece.");
        }

        internalBoard[oldIndices[0]][oldIndices[1]] = Optional.empty();
        pieceAtNewPosition.ifPresent(externalBoard::add);
        internalBoard[newIndices[0]][newIndices[1]] = Optional.empty();

        return true;
    }

    public boolean movePiece(ChessPiece piece, String newPosition) {
        try {
            if (piece.isValidMove(newPosition)) {
                if (positionCheck(piece, newPosition)) {
                    addPiece(piece, newPosition);
                    return true;
                }
            }
        } catch (FriendlyPieceException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean moveFirstPawn(Pawn piece, String newPosition) {
        try {
            if (piece.isFirstValidMove(newPosition)) {
                if (positionCheck(piece, newPosition)) {
                    addPiece(piece, newPosition);
                    return true;
                }
            }
        } catch (FriendlyPieceException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}

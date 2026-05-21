import org.example.ChessBoard;
import org.example.ChessPiece;
import org.example.pieces.Knight;
import org.example.pieces.Pawn;
import org.example.pieces.King;
import org.example.pieces.Queen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.example.ChessPiece.my_color.Black;
import static org.example.ChessPiece.my_color.White;
import static org.junit.jupiter.api.Assertions.*;

class ChessBoardTest {
    private ChessBoard board;

    @BeforeEach
    public void setUp() {
        board = new ChessBoard();
    }

    @Test
    public void canAddPawn(){
        ChessPiece pawn = new Pawn(White);
        boolean result = board.addPiece(pawn, "a2");
        assertEquals(Optional.of(pawn), board.getPieceAt("a2"));
    }

    @Test
    public void cannotAddPawnToInvalidPosition() {
        ChessPiece pawn = new Pawn(White);
        boolean result = board.addPiece(pawn, "i9");
        assertFalse(result);
        Optional<ChessPiece> result2 = board.getPieceAt("i9");
        assertTrue(result2.isEmpty());
    }

    @Test
    public void cannotAddPawnToOccupiedPosition(){
        ChessPiece pawn1 = new Pawn(White);
        ChessPiece pawn2 = new Pawn(Black);

        board.addPiece(pawn1, "a2");
        boolean result = board.addPiece(pawn2, "a2");
        assertFalse(result);
        assertEquals(Optional.of(pawn1), board.getPieceAt("a2") );
    }

    @Test
    public void canPawnMove(){
        ChessPiece pawn1 = new Pawn(White);
        board.addPiece(pawn1, "a2");
        boolean result = board.movePiece(pawn1, "a3");
        assertTrue(result);
    }

    @Test
    public void canKnightMove(){
        ChessPiece knight1 = new Knight(White);

        board.addPiece(knight1, "c1");
        boolean result1 = board.movePiece(knight1, "a5");
        Optional<ChessPiece> result2 = board.getPieceAt("c1");
        Optional<ChessPiece> result3 = board.getPieceAt("a5");
        assertFalse(result1);
        assertEquals(Optional.of(knight1), result2);
        assertEquals(Optional.empty(), result3);
    }

    @Test
    public void canAddKnightToPawnsPreviousPlace(){
        ChessPiece pawn1 = new Pawn(White);
        ChessPiece knight2 = new Knight(White);
        board.addPiece(pawn1, "a2");
        board.movePiece(pawn1,"a3");
        boolean result = board.addPiece(knight2, "a2");
        assertTrue(result);
    }

    @Test
    public void pawnCanMoveTwoForwardOnFirstMove() {
        Pawn pawn1 = new Pawn(White);
        Pawn pawn2 = new Pawn(White);
        board.addPiece(pawn1, "a2");
//        board.addPiece(pawn2, "a4");
        boolean result = board.moveFirstPawn(pawn1, "a4");
        assertTrue(result);
    }

    @Test
    public void blackPawnCanMoveForward(){
        ChessPiece pawn1 = new Pawn(Black);
        ChessPiece pawn2 = new Pawn(Black);

        board.addPiece(pawn2, "d4");
        board.addPiece(pawn1, "d5");

        boolean result = board.movePiece(pawn1, "d4");
        assertFalse(result);
    }

    @Test
    public void blackPawnCanMoveTwoForwardOnFirstMove(){
        Pawn pawn1 = new Pawn(Black);
        board.addPiece(pawn1, "g7");
        boolean result = board.moveFirstPawn(pawn1, "g5");
        assertTrue(result);

    }

    @Test
    public void knightCanMoveToNextRow(){
        ChessPiece knight1 = new Knight(White);
        ChessPiece knight2 = new Knight(Black);
        board.addPiece(knight1, "c2");
        board.addPiece(knight2, "f5");
        boolean result1 = board.movePiece(knight1, "a3");
        assertTrue(result1);
        boolean result2 = board.movePiece(knight2, "d6");
        assertTrue(result2);
    }

    @Test
    public void canMoveC1KnightToD3() {
        ChessPiece knight1 = new Knight(White);
        board.addPiece(knight1, "c1");
        board.movePiece(knight1, "d3");
        Optional<ChessPiece> result1 = board.getPieceAt("c1");
        assertEquals(Optional.empty(), result1);

        Optional<ChessPiece> result2 = board.getPieceAt("d3");
        assertEquals(Optional.of(knight1), result2);
    }

    @Test
    public void canNotMoveC1KnightToFriendlyOccupiedSquare(){
        ChessPiece whiteKnight = new Knight(White);
        ChessPiece whitePawn = new Pawn(White);
        ChessPiece blackPawn = new Pawn(Black);
        board.addPiece(whiteKnight, "c2");
        board.addPiece(whitePawn, "a3");
        board.addPiece(blackPawn, "e1");

//        boolean result1 = board.movePiece(whiteKnight, "a3");
//        boolean result2 = board.movePiece(whiteKnight, "e1");
        board.movePiece(whiteKnight, "e1");
        ChessPiece result3 = board.externalBoard.get(0);
        Optional<ChessPiece> result4 = board.internalBoard[4][7];

        assertEquals(blackPawn, result3);
        assertEquals(Optional.of(whiteKnight), result4);

//        assertFalse(result1);
//        assertTrue(result2);

    }
}
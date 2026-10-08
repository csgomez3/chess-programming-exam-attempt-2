package chess;

import java.util.Collection;
import java.util.ArrayList;

public class LegalMoveAdder {

    public static Collection<ChessMove> AddLegalMoves(ChessBoard board, ChessPosition position) {
        ArrayList<ChessMove> list = new ArrayList<>();
        int startRow = position.getRow();
        int startCol = position.getColumn();
        ChessGame.TeamColor color = board.getPiece(position).getTeamColor();
        ChessPiece.PieceType type = board.getPiece(position).getPieceType();

        switch (type) {
            case ChessPiece.PieceType.KING:
                if (startRow < 8) {
                    list.add(new ChessMove(position,LegalMoveLibrary.north(position,1),null));
                }
                if (startRow > 1) {
                    list.add(new ChessMove(position,LegalMoveLibrary.south(position,1),null));
                }
                if (startCol < 8) {
                    list.add(new ChessMove(position,LegalMoveLibrary.east(position,1),null));
                }
                if (startCol > 1) {
                    list.add(new ChessMove(position,LegalMoveLibrary.west(position,1),null));
                }
                if (startRow < 8 && startCol < 8) {
                    list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.NE),null));
                }
                if (startRow < 8 && startCol > 1) {
                    list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.NW),null));
                }
                if (startRow > 1 && startCol > 1) {
                    list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.SW),null));
                }
                if (startRow > 1 && startCol < 8) {
                    list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.SE),null));
                }
                break;
            case ChessPiece.PieceType.QUEEN:
                for (int dist = 1; dist < 8; dist++) {
                    if (startRow + dist <= 8) {
                        list.add(new ChessMove(position,LegalMoveLibrary.north(position,dist),null));
                    }
                    if (startRow - dist >= 1) {
                        list.add(new ChessMove(position,LegalMoveLibrary.south(position,dist),null));
                    }
                    if (startCol + dist <= 8) {
                        list.add(new ChessMove(position,LegalMoveLibrary.east(position,dist),null));
                    }
                    if (startCol - dist >= 1) {
                        list.add(new ChessMove(position,LegalMoveLibrary.west(position,dist),null));
                    }
                    if (startRow + dist <= 8 && startCol + dist <= 8) {
                        list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,dist,LegalMoveLibrary.diagDir.NE),null));
                    }
                    if (startRow + dist <= 8 && startCol - dist >= 1) {
                        list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,dist,LegalMoveLibrary.diagDir.NW),null));
                    }
                    if (startRow - dist >= 1 && startCol - dist >= 1) {
                        list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,dist,LegalMoveLibrary.diagDir.SW),null));
                    }
                    if (startRow - dist >= 1 && startCol + dist <= 8) {
                        list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,dist,LegalMoveLibrary.diagDir.SE),null));
                    }
                }
                break;
            case ChessPiece.PieceType.ROOK:

                break;
            case ChessPiece.PieceType.BISHOP:

                break;
            case ChessPiece.PieceType.KNIGHT:

                break;
            case ChessPiece.PieceType.PAWN:

                break;
        }

        return list;
    }
}

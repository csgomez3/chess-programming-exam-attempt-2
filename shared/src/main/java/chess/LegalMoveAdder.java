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
                }
                break;
            case ChessPiece.PieceType.BISHOP:
                for (int dist = 1; dist < 8; dist++) {
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
            case ChessPiece.PieceType.KNIGHT:
                if (startRow + 1 <= 8 && startCol + 2 <= 8) {
                    list.add(new ChessMove(position,LegalMoveLibrary.LShape(position,1,LegalMoveLibrary.diagDir.NE),null));
                }
                if (startRow + 2 <= 8 && startCol + 1 <= 8) {
                    list.add(new ChessMove(position,LegalMoveLibrary.LShape(position,2,LegalMoveLibrary.diagDir.NE),null));
                }
                if (startRow + 1 <= 8 && startCol - 2 >= 1) {
                    list.add(new ChessMove(position,LegalMoveLibrary.LShape(position,1,LegalMoveLibrary.diagDir.NW),null));
                }
                if (startRow + 2 <= 8 && startCol - 1 >= 1) {
                    list.add(new ChessMove(position,LegalMoveLibrary.LShape(position,2,LegalMoveLibrary.diagDir.NW),null));
                }
                if (startRow - 1 >= 1 && startCol - 2 >= 1) {
                    list.add(new ChessMove(position,LegalMoveLibrary.LShape(position,1,LegalMoveLibrary.diagDir.SW),null));
                }
                if (startRow - 2 >= 1 && startCol - 1 >= 1) {
                    list.add(new ChessMove(position,LegalMoveLibrary.LShape(position,2,LegalMoveLibrary.diagDir.SW),null));
                }
                if (startRow - 1 >= 1 && startCol + 2 <= 8) {
                    list.add(new ChessMove(position,LegalMoveLibrary.LShape(position,1,LegalMoveLibrary.diagDir.SE),null));
                }
                if (startRow - 2 >= 1 && startCol + 1 <= 8) {
                    list.add(new ChessMove(position,LegalMoveLibrary.LShape(position,2,LegalMoveLibrary.diagDir.SE),null));
                }
                break;
            case ChessPiece.PieceType.PAWN:
                //White Pawn logic
                if (color == ChessGame.TeamColor.WHITE) {
                    //Standard move
                    if (startRow < 8) {
                        list.add(new ChessMove(position,LegalMoveLibrary.north(position,1),null));
                    }
                    //First turn jump
                    if (startRow == 2) {
                        list.add(new ChessMove(position,LegalMoveLibrary.north(position,2),null));
                    }
                    //Capture NE
                    if (startRow < 8 && startCol < 8) {
                        list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.NE),null));
                    }
                    //Capture NW
                    if (startRow < 8 && startCol > 1) {
                        list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.NW),null));
                    }
                    //Standard move and promote
                    if (startRow == 7) {
                        list.add(new ChessMove(position,LegalMoveLibrary.north(position,1),ChessPiece.PieceType.QUEEN));
                        list.add(new ChessMove(position,LegalMoveLibrary.north(position,1),ChessPiece.PieceType.ROOK));
                        list.add(new ChessMove(position,LegalMoveLibrary.north(position,1),ChessPiece.PieceType.BISHOP));
                        list.add(new ChessMove(position,LegalMoveLibrary.north(position,1),ChessPiece.PieceType.KNIGHT));
                    }
                    //Capture NE and promote
                    if (startRow == 7 && startCol < 8) {
                        list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.NE),ChessPiece.PieceType.QUEEN));
                        list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.NE),ChessPiece.PieceType.ROOK));
                        list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.NE),ChessPiece.PieceType.BISHOP));
                        list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.NE),ChessPiece.PieceType.KNIGHT));
                    }
                    //Capture NW and promote
                    if (startRow == 7 && startCol > 1) {
                        list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.NW),ChessPiece.PieceType.QUEEN));
                        list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.NW),ChessPiece.PieceType.ROOK));
                        list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.NW),ChessPiece.PieceType.BISHOP));
                        list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.NW),ChessPiece.PieceType.KNIGHT));;
                    }
                }
                //Black Pawn logic
                else {
                    //Standard move
                    if (startRow > 1) {
                        list.add(new ChessMove(position,LegalMoveLibrary.south(position,1),null));
                    }
                    //First turn jump
                    if (startRow == 7) {
                        list.add(new ChessMove(position,LegalMoveLibrary.south(position,2),null));
                    }
                    //Capture SW
                    if (startRow > 1 && startCol > 1) {
                        list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.SW),null));
                    }
                    //Capture SE
                    if (startRow > 1 && startCol < 8) {
                        list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.SE),null));
                    }
                    //Standard move and promote
                    if (startRow == 2) {
                        list.add(new ChessMove(position,LegalMoveLibrary.south(position,1),ChessPiece.PieceType.QUEEN));
                        list.add(new ChessMove(position,LegalMoveLibrary.south(position,1),ChessPiece.PieceType.ROOK));
                        list.add(new ChessMove(position,LegalMoveLibrary.south(position,1),ChessPiece.PieceType.BISHOP));
                        list.add(new ChessMove(position,LegalMoveLibrary.south(position,1),ChessPiece.PieceType.KNIGHT));
                    }
                    //Capture SW and promote
                    if (startRow == 2 && startCol > 1) {
                        list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.SW),ChessPiece.PieceType.QUEEN));
                        list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.SW),ChessPiece.PieceType.ROOK));
                        list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.SW),ChessPiece.PieceType.BISHOP));
                        list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.SW),ChessPiece.PieceType.KNIGHT));;
                    }
                    //Capture SE and promote
                    if (startRow == 2 && startCol < 8) {
                        list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.SE),ChessPiece.PieceType.QUEEN));
                        list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.SE),ChessPiece.PieceType.ROOK));
                        list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.SE),ChessPiece.PieceType.BISHOP));
                        list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.SE),ChessPiece.PieceType.KNIGHT));;
                    }
                }
                break;
        }

        return list;
    }
}

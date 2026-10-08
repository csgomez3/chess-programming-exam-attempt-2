package chess;

import java.util.Collection;
import java.util.ArrayList;

public class LegalMoveAdder {

    public static Collection<ChessMove> AddLegalMoves(ChessBoard board, ChessPosition position) {
        ArrayList<ChessMove> list = new ArrayList<>();
        int startRow = position.getRow();
        int startCol = position.getColumn();
        ChessPosition endPos;
        ChessGame.TeamColor color = board.getPiece(position).getTeamColor();
        ChessPiece.PieceType type = board.getPiece(position).getPieceType();

        switch (type) {
            case ChessPiece.PieceType.KING:
                endPos = LegalMoveLibrary.north(position,1);
                if (startRow < 8) {
                    list.add(new ChessMove(position,endPos,null));
                }
                endPos = LegalMoveLibrary.south(position,1);
                if (startRow > 1) {
                    list.add(new ChessMove(position,endPos,null));
                }
                endPos = LegalMoveLibrary.east(position,1);
                if (startCol < 8) {
                    list.add(new ChessMove(position,endPos,null));
                }
                endPos = LegalMoveLibrary.west(position,1);
                if (startCol > 1) {
                    list.add(new ChessMove(position,endPos,null));
                }
                endPos = LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.NE);
                if (startRow < 8 && startCol < 8) {
                    list.add(new ChessMove(position,endPos,null));
                }
                endPos = LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.NW);
                if (startRow < 8 && startCol > 1) {
                    list.add(new ChessMove(position,endPos,null));
                }
                endPos = LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.SW);
                if (startRow > 1 && startCol > 1) {
                    list.add(new ChessMove(position,endPos,null));
                }
                endPos = LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.SE);
                if (startRow > 1 && startCol < 8) {
                    list.add(new ChessMove(position,endPos,null));
                }
                break;
            case ChessPiece.PieceType.QUEEN:
                for (int dist = 1; dist < 8; dist++) {
                    endPos = LegalMoveLibrary.north(position,dist);
                    if (startRow + dist <= 8) {
                        list.add(new ChessMove(position,endPos,null));
                    }
                    endPos = LegalMoveLibrary.south(position,dist);
                    if (startRow - dist >= 1) {
                        list.add(new ChessMove(position,endPos,null));
                    }
                    endPos = LegalMoveLibrary.east(position,dist);
                    if (startCol + dist <= 8) {
                        list.add(new ChessMove(position,endPos,null));
                    }
                    endPos = LegalMoveLibrary.west(position,dist);
                    if (startCol - dist >= 1) {
                        list.add(new ChessMove(position,endPos,null));
                    }
                    endPos = LegalMoveLibrary.diagonal(position,dist,LegalMoveLibrary.diagDir.NE);
                    if (startRow + dist <= 8 && startCol + dist <= 8) {
                        list.add(new ChessMove(position,endPos,null));
                    }
                    endPos = LegalMoveLibrary.diagonal(position,dist,LegalMoveLibrary.diagDir.NW);
                    if (startRow + dist <= 8 && startCol - dist >= 1) {
                        list.add(new ChessMove(position,endPos,null));
                    }
                    endPos = LegalMoveLibrary.diagonal(position,dist,LegalMoveLibrary.diagDir.SW);
                    if (startRow - dist >= 1 && startCol - dist >= 1) {
                        list.add(new ChessMove(position,endPos,null));
                    }
                    endPos = LegalMoveLibrary.diagonal(position,dist,LegalMoveLibrary.diagDir.SE);
                    if (startRow - dist >= 1 && startCol + dist <= 8) {
                        list.add(new ChessMove(position,endPos,null));
                    }
                }
                break;
            case ChessPiece.PieceType.ROOK:
                for (int dist = 1; dist < 8; dist++) {
                    endPos = LegalMoveLibrary.north(position,dist);
                    if (startRow + dist <= 8) {
                        list.add(new ChessMove(position,endPos,null));
                    }
                    endPos = LegalMoveLibrary.south(position,dist);
                    if (startRow - dist >= 1) {
                        list.add(new ChessMove(position,endPos,null));
                    }
                    endPos = LegalMoveLibrary.east(position,dist);
                    if (startCol + dist <= 8) {
                        list.add(new ChessMove(position,endPos,null));
                    }
                    endPos = LegalMoveLibrary.west(position,dist);
                    if (startCol - dist >= 1) {
                        list.add(new ChessMove(position,endPos,null));
                    }
                }
                break;
            case ChessPiece.PieceType.BISHOP:
                for (int dist = 1; dist < 8; dist++) {
                    endPos = LegalMoveLibrary.diagonal(position,dist,LegalMoveLibrary.diagDir.NE);
                    if (startRow + dist <= 8 && startCol + dist <= 8) {
                        list.add(new ChessMove(position,endPos,null));
                    }
                    endPos = LegalMoveLibrary.diagonal(position,dist,LegalMoveLibrary.diagDir.NW);
                    if (startRow + dist <= 8 && startCol - dist >= 1) {
                        list.add(new ChessMove(position,endPos,null));
                    }
                    endPos = LegalMoveLibrary.diagonal(position,dist,LegalMoveLibrary.diagDir.SW);
                    if (startRow - dist >= 1 && startCol - dist >= 1) {
                        list.add(new ChessMove(position,endPos,null));
                    }
                    endPos = LegalMoveLibrary.diagonal(position,dist,LegalMoveLibrary.diagDir.SE);
                    if (startRow - dist >= 1 && startCol + dist <= 8) {
                        list.add(new ChessMove(position,endPos,null));
                    }
                }
                break;
            case ChessPiece.PieceType.KNIGHT:
                endPos = LegalMoveLibrary.LShape(position,1,LegalMoveLibrary.diagDir.NE);
                if (startRow + 1 <= 8 && startCol + 2 <= 8) {
                    list.add(new ChessMove(position,endPos,null));
                }
                endPos = LegalMoveLibrary.LShape(position,2,LegalMoveLibrary.diagDir.NE);
                if (startRow + 2 <= 8 && startCol + 1 <= 8) {
                    list.add(new ChessMove(position,endPos,null));
                }
                endPos = LegalMoveLibrary.LShape(position,1,LegalMoveLibrary.diagDir.NW);
                if (startRow + 1 <= 8 && startCol - 2 >= 1) {
                    list.add(new ChessMove(position,endPos,null));
                }
                endPos = LegalMoveLibrary.LShape(position,2,LegalMoveLibrary.diagDir.NW);
                if (startRow + 2 <= 8 && startCol - 1 >= 1) {
                    list.add(new ChessMove(position,endPos,null));
                }
                endPos = LegalMoveLibrary.LShape(position,1,LegalMoveLibrary.diagDir.SW);
                if (startRow - 1 >= 1 && startCol - 2 >= 1) {
                    list.add(new ChessMove(position,endPos,null));
                }
                endPos = LegalMoveLibrary.LShape(position,2,LegalMoveLibrary.diagDir.SW);
                if (startRow - 2 >= 1 && startCol - 1 >= 1) {
                    list.add(new ChessMove(position,endPos,null));
                }
                endPos = LegalMoveLibrary.LShape(position,1,LegalMoveLibrary.diagDir.SE);
                if (startRow - 1 >= 1 && startCol + 2 <= 8) {
                    list.add(new ChessMove(position,endPos,null));
                }
                endPos = LegalMoveLibrary.LShape(position,2,LegalMoveLibrary.diagDir.SE);
                if (startRow - 2 >= 1 && startCol + 1 <= 8) {
                    list.add(new ChessMove(position,endPos,null));
                }
                break;
            case ChessPiece.PieceType.PAWN:
                //White Pawn logic
                if (color == ChessGame.TeamColor.WHITE) {
                    //Standard move
                    endPos = LegalMoveLibrary.north(position,1);
                    if (startRow < 8) {
                        list.add(new ChessMove(position,endPos,null));
                    }
                    //First turn jump
                    endPos = LegalMoveLibrary.north(position,2);
                    if (startRow == 2) {
                        list.add(new ChessMove(position,endPos,null));
                    }
                    //Capture NE
                    endPos = LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.NE);
                    if (startRow < 8 && startCol < 8) {
                        list.add(new ChessMove(position,endPos,null));
                    }
                    //Capture NW
                    endPos = LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.NE);
                    if (startRow < 8 && startCol > 1) {
                        list.add(new ChessMove(position,endPos,null));
                    }
                    //Standard move and promote
                    endPos = LegalMoveLibrary.north(position,1);
                    if (startRow == 7) {
                        list.add(new ChessMove(position,endPos,ChessPiece.PieceType.QUEEN));
                        list.add(new ChessMove(position,endPos,ChessPiece.PieceType.ROOK));
                        list.add(new ChessMove(position,endPos,ChessPiece.PieceType.BISHOP));
                        list.add(new ChessMove(position,endPos,ChessPiece.PieceType.KNIGHT));
                    }
                    //Capture NE and promote
                    endPos = LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.NE);
                    if (startRow == 7 && startCol < 8) {
                        list.add(new ChessMove(position,endPos,ChessPiece.PieceType.QUEEN));
                        list.add(new ChessMove(position,endPos,ChessPiece.PieceType.ROOK));
                        list.add(new ChessMove(position,endPos,ChessPiece.PieceType.BISHOP));
                        list.add(new ChessMove(position,endPos,ChessPiece.PieceType.KNIGHT));
                    }
                    //Capture NW and promote
                    endPos = LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.NW);
                    if (startRow == 7 && startCol > 1) {
                        list.add(new ChessMove(position,endPos,ChessPiece.PieceType.QUEEN));
                        list.add(new ChessMove(position,endPos,ChessPiece.PieceType.ROOK));
                        list.add(new ChessMove(position,endPos,ChessPiece.PieceType.BISHOP));
                        list.add(new ChessMove(position,endPos,ChessPiece.PieceType.KNIGHT));
                    }
                }
                //Black Pawn logic
                else {
                    //Standard move
                    endPos = LegalMoveLibrary.south(position,1);
                    if (startRow > 1) {
                        list.add(new ChessMove(position,endPos,null));
                    }
                    //First turn jump
                    endPos = LegalMoveLibrary.south(position,2);
                    if (startRow == 7) {
                        list.add(new ChessMove(position,endPos,null));
                    }
                    //Capture SW
                    endPos = LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.SW);
                    if (startRow > 1 && startCol > 1) {
                        list.add(new ChessMove(position,endPos,null));
                    }
                    //Capture SE
                    endPos = LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.SE);
                    if (startRow > 1 && startCol < 8) {
                        list.add(new ChessMove(position,endPos,null));
                    }
                    //Standard move and promote
                    endPos = LegalMoveLibrary.south(position,1);
                    if (startRow == 2) {
                        list.add(new ChessMove(position,endPos,ChessPiece.PieceType.QUEEN));
                        list.add(new ChessMove(position,endPos,ChessPiece.PieceType.ROOK));
                        list.add(new ChessMove(position,endPos,ChessPiece.PieceType.BISHOP));
                        list.add(new ChessMove(position,endPos,ChessPiece.PieceType.KNIGHT));
                    }
                    //Capture SW and promote
                    endPos = LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.SW);
                    if (startRow == 2 && startCol > 1) {
                        list.add(new ChessMove(position,endPos,ChessPiece.PieceType.QUEEN));
                        list.add(new ChessMove(position,endPos,ChessPiece.PieceType.ROOK));
                        list.add(new ChessMove(position,endPos,ChessPiece.PieceType.BISHOP));
                        list.add(new ChessMove(position,endPos,ChessPiece.PieceType.KNIGHT));
                    }
                    //Capture SE and promote
                    endPos = LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.SE);
                    if (startRow == 2 && startCol < 8) {
                        list.add(new ChessMove(position,endPos,ChessPiece.PieceType.QUEEN));
                        list.add(new ChessMove(position,endPos,ChessPiece.PieceType.ROOK));
                        list.add(new ChessMove(position,endPos,ChessPiece.PieceType.BISHOP));
                        list.add(new ChessMove(position,endPos,ChessPiece.PieceType.KNIGHT));
                    }
                }
                break;
        }

        return list;
    }
}

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
        boolean pathNorthClear = true;
        boolean pathSouthClear = true;
        boolean pathEastClear = true;
        boolean pathWestClear = true;
        boolean pathNEClear = true;
        boolean pathNWClear = true;
        boolean pathSWClear = true;
        boolean pathSEClear = true;

        switch (type) {
            case ChessPiece.PieceType.KING:
                if (startRow < 8 && (board.getPiece(new ChessPosition(startRow+1,startCol)) == null || board.getPiece(new ChessPosition(startRow+1,startCol)).getTeamColor() != color)) {
                    list.add(new ChessMove(position,LegalMoveLibrary.north(position,1),null));
                }
                if (startRow > 1 && (board.getPiece(new ChessPosition(startRow-1,startCol)) == null || board.getPiece(new ChessPosition(startRow-1,startCol)).getTeamColor() != color)) {
                    list.add(new ChessMove(position,LegalMoveLibrary.south(position,1),null));
                }
                if (startCol < 8 && (board.getPiece(new ChessPosition(startRow,startCol+1)) == null || board.getPiece(new ChessPosition(startRow,startCol+1)).getTeamColor() != color)) {
                    list.add(new ChessMove(position,LegalMoveLibrary.east(position,1),null));
                }
                if (startCol > 1 && (board.getPiece(new ChessPosition(startRow,startCol-1)) == null || board.getPiece(new ChessPosition(startRow,startCol-1)).getTeamColor() != color)) {
                    list.add(new ChessMove(position,LegalMoveLibrary.west(position,1),null));
                }
                if (startRow < 8 && startCol < 8 && (board.getPiece(new ChessPosition(startRow+1,startCol+1)) == null || board.getPiece(new ChessPosition(startRow+1,startCol+1)).getTeamColor() != color)) {
                    list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.NE),null));
                }
                if (startRow < 8 && startCol > 1 && (board.getPiece(new ChessPosition(startRow+1,startCol-1)) == null || board.getPiece(new ChessPosition(startRow+1,startCol-1)).getTeamColor() != color)) {
                    list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.NW),null));
                }
                if (startRow > 1 && startCol > 1 && (board.getPiece(new ChessPosition(startRow-1,startCol-1)) == null || board.getPiece(new ChessPosition(startRow-1,startCol-1)).getTeamColor() != color)) {
                    list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.SW),null));
                }
                if (startRow > 1 && startCol < 8 && (board.getPiece(new ChessPosition(startRow-1,startCol+1)) == null || board.getPiece(new ChessPosition(startRow-1,startCol+1)).getTeamColor() != color)) {
                    list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.SE),null));
                }
                break;
            case ChessPiece.PieceType.QUEEN:
                for (int dist = 1; dist < 8; dist++) {
                    //North
                    if (startRow + dist <= 8 && board.getPiece(new ChessPosition(startRow+dist,startCol)) != null && board.getPiece(new ChessPosition(startRow+dist,startCol)).getTeamColor() == color) {
                        pathNorthClear = false;
                    }
                    if (startRow + dist <= 8 && pathNorthClear) {
                        list.add(new ChessMove(position,LegalMoveLibrary.north(position,dist),null));
                        if (board.getPiece(new ChessPosition(startRow+dist,startCol)) != null && board.getPiece(new ChessPosition(startRow+dist,startCol)).getTeamColor() != color) {
                            pathNorthClear = false;
                        }
                    }
                    //South
                    if (startRow - dist >= 1 && board.getPiece(new ChessPosition(startRow-dist,startCol)) != null && board.getPiece(new ChessPosition(startRow-dist,startCol)).getTeamColor() == color) {
                        pathSouthClear = false;
                    }
                    if (startRow - dist >= 1 && pathSouthClear) {
                        list.add(new ChessMove(position,LegalMoveLibrary.south(position,dist),null));
                        if (board.getPiece(new ChessPosition(startRow-dist,startCol)) != null && board.getPiece(new ChessPosition(startRow-dist,startCol)).getTeamColor() != color) {
                            pathSouthClear = false;
                        }
                    }
                    //East
                    if (startCol + dist <= 8 && board.getPiece(new ChessPosition(startRow,startCol+dist)) != null && board.getPiece(new ChessPosition(startRow,startCol+dist)).getTeamColor() == color) {
                        pathEastClear = false;
                    }
                    if (startCol + dist <= 8 && pathEastClear) {
                        list.add(new ChessMove(position,LegalMoveLibrary.east(position,dist),null));
                        if (board.getPiece(new ChessPosition(startRow,startCol+dist)) != null && board.getPiece(new ChessPosition(startRow,startCol+dist)).getTeamColor() != color) {
                            pathEastClear = false;
                        }
                    }
                    //West
                    if (startCol - dist >= 1 && board.getPiece(new ChessPosition(startRow,startCol-dist)) != null && board.getPiece(new ChessPosition(startRow,startCol-dist)).getTeamColor() == color) {
                        pathWestClear = false;
                    }
                    if (startCol - dist >= 1 && pathWestClear) {
                        list.add(new ChessMove(position,LegalMoveLibrary.west(position,dist),null));
                        if (board.getPiece(new ChessPosition(startRow,startCol-dist)) != null && board.getPiece(new ChessPosition(startRow,startCol-dist)).getTeamColor() != color) {
                            pathWestClear = false;
                        }
                    }
                    //NE
                    if (startRow + dist <= 8 && startCol + dist <= 8 && board.getPiece(new ChessPosition(startRow+dist,startCol+dist)) != null && board.getPiece(new ChessPosition(startRow+dist,startCol+dist)).getTeamColor() == color) {
                        pathNEClear = false;
                    }
                    if (startRow + dist <= 8 && startCol + dist <= 8 && pathNEClear) {
                        list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,dist,LegalMoveLibrary.diagDir.NE),null));
                        if (board.getPiece(new ChessPosition(startRow+dist,startCol+dist)) != null && board.getPiece(new ChessPosition(startRow+dist,startCol+dist)).getTeamColor() != color) {
                            pathNEClear = false;
                        }
                    }
                    //NW
                    if (startRow + dist <= 8 && startCol - dist >= 1 && board.getPiece(new ChessPosition(startRow+dist,startCol-dist)) != null && board.getPiece(new ChessPosition(startRow+dist,startCol-dist)).getTeamColor() == color) {
                        pathNWClear = false;
                    }
                    if (startRow + dist <= 8 && startCol - dist >= 1 && pathNWClear) {
                        list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,dist,LegalMoveLibrary.diagDir.NW),null));
                        if (board.getPiece(new ChessPosition(startRow+dist,startCol-dist)) != null && board.getPiece(new ChessPosition(startRow+dist,startCol-dist)).getTeamColor() != color) {
                            pathNWClear = false;
                        }
                    }
                    //SW
                    if (startRow - dist >= 1 && startCol - dist >= 1 && board.getPiece(new ChessPosition(startRow-dist,startCol-dist)) != null && board.getPiece(new ChessPosition(startRow-dist,startCol-dist)).getTeamColor() == color) {
                        pathSWClear = false;
                    }
                    if (startRow - dist >= 1 && startCol - dist >= 1 && pathSWClear) {
                        list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,dist,LegalMoveLibrary.diagDir.SW),null));
                        if (board.getPiece(new ChessPosition(startRow-dist,startCol-dist)) != null && board.getPiece(new ChessPosition(startRow-dist,startCol-dist)).getTeamColor() != color) {
                            pathSWClear = false;
                        }
                    }
                    //SE
                    if (startRow - dist >= 1 && startCol + dist <= 8 && board.getPiece(new ChessPosition(startRow-dist,startCol+dist)) != null && board.getPiece(new ChessPosition(startRow-dist,startCol+dist)).getTeamColor() == color) {
                        pathSEClear = false;
                    }
                    if (startRow - dist >= 1 && startCol + dist <= 8 && pathSEClear) {
                        list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,dist,LegalMoveLibrary.diagDir.SE),null));
                        if (board.getPiece(new ChessPosition(startRow-dist,startCol+dist)) != null && board.getPiece(new ChessPosition(startRow-dist,startCol+dist)).getTeamColor() != color) {
                            pathSEClear = false;
                        }
                    }
                }
                break;
            case ChessPiece.PieceType.ROOK:
                for (int dist = 1; dist < 8; dist++) {
                    //North
                    if (startRow + dist <= 8 && board.getPiece(new ChessPosition(startRow+dist,startCol)) != null && board.getPiece(new ChessPosition(startRow+dist,startCol)).getTeamColor() == color) {
                        pathNorthClear = false;
                    }
                    if (startRow + dist <= 8 && pathNorthClear) {
                        list.add(new ChessMove(position,LegalMoveLibrary.north(position,dist),null));
                        if (board.getPiece(new ChessPosition(startRow+dist,startCol)) != null && board.getPiece(new ChessPosition(startRow+dist,startCol)).getTeamColor() != color) {
                            pathNorthClear = false;
                        }
                    }
                    //South
                    if (startRow - dist >= 1 && board.getPiece(new ChessPosition(startRow-dist,startCol)) != null && board.getPiece(new ChessPosition(startRow-dist,startCol)).getTeamColor() == color) {
                        pathSouthClear = false;
                    }
                    if (startRow - dist >= 1 && pathSouthClear) {
                        list.add(new ChessMove(position,LegalMoveLibrary.south(position,dist),null));
                        if (board.getPiece(new ChessPosition(startRow-dist,startCol)) != null && board.getPiece(new ChessPosition(startRow-dist,startCol)).getTeamColor() != color) {
                            pathSouthClear = false;
                        }
                    }
                    //East
                    if (startCol + dist <= 8 && board.getPiece(new ChessPosition(startRow,startCol+dist)) != null && board.getPiece(new ChessPosition(startRow,startCol+dist)).getTeamColor() == color) {
                        pathEastClear = false;
                    }
                    if (startCol + dist <= 8 && pathEastClear) {
                        list.add(new ChessMove(position,LegalMoveLibrary.east(position,dist),null));
                        if (board.getPiece(new ChessPosition(startRow,startCol+dist)) != null && board.getPiece(new ChessPosition(startRow,startCol+dist)).getTeamColor() != color) {
                            pathEastClear = false;
                        }
                    }
                    //West
                    if (startCol - dist >= 1 && board.getPiece(new ChessPosition(startRow,startCol-dist)) != null && board.getPiece(new ChessPosition(startRow,startCol-dist)).getTeamColor() == color) {
                        pathWestClear = false;
                    }
                    if (startCol - dist >= 1 && pathWestClear) {
                        list.add(new ChessMove(position,LegalMoveLibrary.west(position,dist),null));
                        if (board.getPiece(new ChessPosition(startRow,startCol-dist)) != null && board.getPiece(new ChessPosition(startRow,startCol-dist)).getTeamColor() != color) {
                            pathWestClear = false;
                        }
                    }
                }
                break;
            case ChessPiece.PieceType.BISHOP:
                for (int dist = 1; dist < 8; dist++) {
                    //NE
                    if (startRow + dist <= 8 && startCol + dist <= 8 && board.getPiece(new ChessPosition(startRow+dist,startCol+dist)) != null && board.getPiece(new ChessPosition(startRow+dist,startCol+dist)).getTeamColor() == color) {
                        pathNEClear = false;
                    }
                    if (startRow + dist <= 8 && startCol + dist <= 8 && pathNEClear) {
                        list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,dist,LegalMoveLibrary.diagDir.NE),null));
                        if (board.getPiece(new ChessPosition(startRow+dist,startCol+dist)) != null && board.getPiece(new ChessPosition(startRow+dist,startCol+dist)).getTeamColor() != color) {
                            pathNEClear = false;
                        }
                    }
                    //NW
                    if (startRow + dist <= 8 && startCol - dist >= 1 && board.getPiece(new ChessPosition(startRow+dist,startCol-dist)) != null && board.getPiece(new ChessPosition(startRow+dist,startCol-dist)).getTeamColor() == color) {
                        pathNWClear = false;
                    }
                    if (startRow + dist <= 8 && startCol - dist >= 1 && pathNWClear) {
                        list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,dist,LegalMoveLibrary.diagDir.NW),null));
                        if (board.getPiece(new ChessPosition(startRow+dist,startCol-dist)) != null && board.getPiece(new ChessPosition(startRow+dist,startCol-dist)).getTeamColor() != color) {
                            pathNWClear = false;
                        }
                    }
                    //SW
                    if (startRow - dist >= 1 && startCol - dist >= 1 && board.getPiece(new ChessPosition(startRow-dist,startCol-dist)) != null && board.getPiece(new ChessPosition(startRow-dist,startCol-dist)).getTeamColor() == color) {
                        pathSWClear = false;
                    }
                    if (startRow - dist >= 1 && startCol - dist >= 1 && pathSWClear) {
                        list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,dist,LegalMoveLibrary.diagDir.SW),null));
                        if (board.getPiece(new ChessPosition(startRow-dist,startCol-dist)) != null && board.getPiece(new ChessPosition(startRow-dist,startCol-dist)).getTeamColor() != color) {
                            pathSWClear = false;
                        }
                    }
                    //SE
                    if (startRow - dist >= 1 && startCol + dist <= 8 && board.getPiece(new ChessPosition(startRow-dist,startCol+dist)) != null && board.getPiece(new ChessPosition(startRow-dist,startCol+dist)).getTeamColor() == color) {
                        pathSEClear = false;
                    }
                    if (startRow - dist >= 1 && startCol + dist <= 8 && pathSEClear) {
                        list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,dist,LegalMoveLibrary.diagDir.SE),null));
                        if (board.getPiece(new ChessPosition(startRow-dist,startCol+dist)) != null && board.getPiece(new ChessPosition(startRow-dist,startCol+dist)).getTeamColor() != color) {
                            pathSEClear = false;
                        }
                    }
                }
                break;
            case ChessPiece.PieceType.KNIGHT:
                if (startRow + 1 <= 8 && startCol + 2 <= 8 && (board.getPiece(new ChessPosition(startRow+1,startCol+2)) == null || board.getPiece(new ChessPosition(startRow+1,startCol+2)).getTeamColor() != color)) {
                    list.add(new ChessMove(position,LegalMoveLibrary.LShape(position,1,LegalMoveLibrary.diagDir.NE),null));
                }
                if (startRow + 2 <= 8 && startCol + 1 <= 8 && (board.getPiece(new ChessPosition(startRow+2,startCol+1)) == null || board.getPiece(new ChessPosition(startRow+2,startCol+1)).getTeamColor() != color)) {
                    list.add(new ChessMove(position,LegalMoveLibrary.LShape(position,2,LegalMoveLibrary.diagDir.NE),null));
                }
                if (startRow + 1 <= 8 && startCol - 2 >= 1 && (board.getPiece(new ChessPosition(startRow+1,startCol-2)) == null || board.getPiece(new ChessPosition(startRow+1,startCol-2)).getTeamColor() != color)) {
                    list.add(new ChessMove(position,LegalMoveLibrary.LShape(position,1,LegalMoveLibrary.diagDir.NW),null));
                }
                if (startRow + 2 <= 8 && startCol - 1 >= 1 && (board.getPiece(new ChessPosition(startRow+2,startCol-1)) == null || board.getPiece(new ChessPosition(startRow+2,startCol-1)).getTeamColor() != color)) {
                    list.add(new ChessMove(position,LegalMoveLibrary.LShape(position,2,LegalMoveLibrary.diagDir.NW),null));
                }
                if (startRow - 1 >= 1 && startCol - 2 >= 1 && (board.getPiece(new ChessPosition(startRow-1,startCol-2)) == null || board.getPiece(new ChessPosition(startRow-1,startCol-2)).getTeamColor() != color)) {
                    list.add(new ChessMove(position,LegalMoveLibrary.LShape(position,1,LegalMoveLibrary.diagDir.SW),null));
                }
                if (startRow - 2 >= 1 && startCol - 1 >= 1 && (board.getPiece(new ChessPosition(startRow-2,startCol-1)) == null || board.getPiece(new ChessPosition(startRow-2,startCol-1)).getTeamColor() != color)) {
                    list.add(new ChessMove(position,LegalMoveLibrary.LShape(position,2,LegalMoveLibrary.diagDir.SW),null));
                }
                if (startRow - 1 >= 1 && startCol + 2 <= 8 && (board.getPiece(new ChessPosition(startRow-1,startCol+2)) == null || board.getPiece(new ChessPosition(startRow-1,startCol+2)).getTeamColor() != color)) {
                    list.add(new ChessMove(position,LegalMoveLibrary.LShape(position,1,LegalMoveLibrary.diagDir.SE),null));
                }
                if (startRow - 2 >= 1 && startCol + 1 <= 8 && (board.getPiece(new ChessPosition(startRow-2,startCol+1)) == null || board.getPiece(new ChessPosition(startRow-2,startCol+1)).getTeamColor() != color)) {
                    list.add(new ChessMove(position,LegalMoveLibrary.LShape(position,2,LegalMoveLibrary.diagDir.SE),null));
                }
                break;
            case ChessPiece.PieceType.PAWN:
                //White Pawn logic
                if (color == ChessGame.TeamColor.WHITE) {
                    //Standard move
                    if (startRow < 7 && board.getPiece(new ChessPosition(startRow+1,startCol)) == null) {
                        list.add(new ChessMove(position,LegalMoveLibrary.north(position,1),null));
                    }
                    //First turn jump
                    if (startRow == 2 && board.getPiece(new ChessPosition(startRow+1,startCol)) == null && board.getPiece(new ChessPosition(startRow+2,startCol)) == null) {
                        list.add(new ChessMove(position,LegalMoveLibrary.north(position,2),null));
                    }
                    //Capture NE
                    if (startRow < 7 && startCol < 8 && board.getPiece(new ChessPosition(startRow+1,startCol+1)) != null && board.getPiece(new ChessPosition(startRow+1,startCol+1)).getTeamColor() != color) {
                        list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.NE),null));
                    }
                    //Capture NW
                    if (startRow < 7 && startCol > 1 && board.getPiece(new ChessPosition(startRow+1,startCol-1)) != null && board.getPiece(new ChessPosition(startRow+1,startCol-1)).getTeamColor() != color) {
                        list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.NW),null));
                    }
                    //Standard move and promote
                    if (startRow == 7 && board.getPiece(new ChessPosition(startRow+1,startCol)) == null) {
                        list.add(new ChessMove(position,LegalMoveLibrary.north(position,1),ChessPiece.PieceType.QUEEN));
                        list.add(new ChessMove(position,LegalMoveLibrary.north(position,1),ChessPiece.PieceType.ROOK));
                        list.add(new ChessMove(position,LegalMoveLibrary.north(position,1),ChessPiece.PieceType.BISHOP));
                        list.add(new ChessMove(position,LegalMoveLibrary.north(position,1),ChessPiece.PieceType.KNIGHT));
                    }
                    //Capture NE and promote
                    if (startRow == 7 && startCol < 8 && board.getPiece(new ChessPosition(startRow+1,startCol+1)) != null && board.getPiece(new ChessPosition(startRow+1,startCol+1)).getTeamColor() != color) {
                        list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.NE),ChessPiece.PieceType.QUEEN));
                        list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.NE),ChessPiece.PieceType.ROOK));
                        list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.NE),ChessPiece.PieceType.BISHOP));
                        list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.NE),ChessPiece.PieceType.KNIGHT));
                    }
                    //Capture NW and promote
                    if (startRow == 7 && startCol > 1 && board.getPiece(new ChessPosition(startRow+1,startCol-1)) != null && board.getPiece(new ChessPosition(startRow+1,startCol-1)).getTeamColor() != color) {
                        list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.NW),ChessPiece.PieceType.QUEEN));
                        list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.NW),ChessPiece.PieceType.ROOK));
                        list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.NW),ChessPiece.PieceType.BISHOP));
                        list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.NW),ChessPiece.PieceType.KNIGHT));
                    }
                }
                //Black Pawn logic
                else {
                    //Standard move
                    if (startRow > 2 && board.getPiece(new ChessPosition(startRow-1,startCol)) == null) {
                        list.add(new ChessMove(position,LegalMoveLibrary.south(position,1),null));
                    }
                    //First turn jump
                    if (startRow == 7 && board.getPiece(new ChessPosition(startRow-1,startCol)) == null && board.getPiece(new ChessPosition(startRow-2,startCol)) == null) {
                        list.add(new ChessMove(position,LegalMoveLibrary.south(position,2),null));
                    }
                    //Capture SW
                    if (startRow > 2 && startCol > 1  && board.getPiece(new ChessPosition(startRow-1,startCol-1)) != null && board.getPiece(new ChessPosition(startRow-1,startCol-1)).getTeamColor() != color) {
                        list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.SW),null));
                    }
                    //Capture SE
                    if (startRow > 2 && startCol < 8 && board.getPiece(new ChessPosition(startRow-1,startCol+1)) != null && board.getPiece(new ChessPosition(startRow-1,startCol+1)).getTeamColor() != color) {
                        list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.SE),null));
                    }
                    //Standard move and promote
                    if (startRow == 2 && board.getPiece(new ChessPosition(startRow-1,startCol)) == null) {
                        list.add(new ChessMove(position,LegalMoveLibrary.south(position,1),ChessPiece.PieceType.QUEEN));
                        list.add(new ChessMove(position,LegalMoveLibrary.south(position,1),ChessPiece.PieceType.ROOK));
                        list.add(new ChessMove(position,LegalMoveLibrary.south(position,1),ChessPiece.PieceType.BISHOP));
                        list.add(new ChessMove(position,LegalMoveLibrary.south(position,1),ChessPiece.PieceType.KNIGHT));
                    }
                    //Capture SW and promote
                    if (startRow == 2 && startCol > 1  && board.getPiece(new ChessPosition(startRow-1,startCol-1)) != null && board.getPiece(new ChessPosition(startRow-1,startCol-1)).getTeamColor() != color) {
                        list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.SW),ChessPiece.PieceType.QUEEN));
                        list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.SW),ChessPiece.PieceType.ROOK));
                        list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.SW),ChessPiece.PieceType.BISHOP));
                        list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.SW),ChessPiece.PieceType.KNIGHT));
                    }
                    //Capture SE and promote
                    if (startRow == 2 && startCol < 8 && board.getPiece(new ChessPosition(startRow-1,startCol+1)) != null && board.getPiece(new ChessPosition(startRow-1,startCol+1)).getTeamColor() != color) {
                        list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.SE),ChessPiece.PieceType.QUEEN));
                        list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.SE),ChessPiece.PieceType.ROOK));
                        list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.SE),ChessPiece.PieceType.BISHOP));
                        list.add(new ChessMove(position,LegalMoveLibrary.diagonal(position,1,LegalMoveLibrary.diagDir.SE),ChessPiece.PieceType.KNIGHT));
                    }
                }
                break;
        }

        return list;
    }
}

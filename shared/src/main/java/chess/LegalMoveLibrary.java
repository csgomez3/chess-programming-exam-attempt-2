package chess;

public class LegalMoveLibrary {

    public enum diagDir {
        NE,
        NW,
        SW,
        SE
    }

    public static ChessPosition north(ChessPosition start, int dist) {
        return new ChessPosition(start.getRow()+dist,start.getColumn());
    }

    public static ChessPosition south(ChessPosition start, int dist) {
        return new ChessPosition(start.getRow()-dist,start.getColumn());
    }

    public static ChessPosition east(ChessPosition start, int dist) {
        return new ChessPosition(start.getRow(),start.getColumn()+dist);
    }

    public static ChessPosition west(ChessPosition start, int dist) {
        return new ChessPosition(start.getRow(),start.getColumn()-dist);
    }

    public static ChessPosition diagonal(ChessPosition start, int dist, diagDir direction) {
        if (direction == diagDir.NE) {
            return new ChessPosition(start.getRow()+dist,start.getColumn()+dist);
        }
        else if (direction == diagDir.NW) {
            return new ChessPosition(start.getRow()+dist,start.getColumn()-dist);
        }
        else if (direction == diagDir.SW) {
            return new ChessPosition(start.getRow()-dist,start.getColumn()-dist);
        }
        else {
            return new ChessPosition(start.getRow()-dist,start.getColumn()+dist);
        }
    }

    public static ChessPosition LShape(ChessPosition start, int rowDist, diagDir direction) {
        if (direction == diagDir.NE) {
            if (rowDist == 1) {
                return new ChessPosition(start.getRow()+1, start.getColumn()+2);
            }
            else {
                return new ChessPosition(start.getRow()+2,start.getColumn()+1);
            }
        }
        else if (direction == diagDir.NW) {
            if (rowDist == 1) {
                return new ChessPosition(start.getRow()+1, start.getColumn()-2);
            }
            else {
                return new ChessPosition(start.getRow()+2,start.getColumn()-1);
            }
        }
        else if (direction == diagDir.SW) {
            if (rowDist == 1) {
                return new ChessPosition(start.getRow()-1, start.getColumn()-2);
            }
            else {
                return new ChessPosition(start.getRow()-2,start.getColumn()-1);
            }
        }
        else {
            if (rowDist == 1) {
                return new ChessPosition(start.getRow()-1, start.getColumn()+2);
            }
            else {
                return new ChessPosition(start.getRow()-2,start.getColumn()+1);
            }
        }
    }
}

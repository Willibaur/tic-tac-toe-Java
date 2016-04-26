
public class TicTacToe {

    private Character[][] board = {{'\0', '\0', '\0'},
                                   {'\0', '\0', '\0'},
                                   {'\0', '\0', '\0'}};

    private char lastPlayer = '\0';

    private static final int SIZE = 3;

    public String play(int x, int y) {
        checkAxis(x);
        checkAxis(y);
        lastPlayer = nextPlayer();
        setBox(x, y, lastPlayer);
        if (isWin()) {
            return lastPlayer + " is the winner";
        } else if (isDraw()) {
            return "The result is draw";
        }
        return "No winner";
    }

    private boolean isDraw() {
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                if (board[x][y] == '\0') {
                    return false;
                }
            }
        }
        return  true;
    }

    private boolean isWin() {
        int playerTotal = lastPlayer * SIZE;
        char diagonal1 = '\0';
        char diagonal2 = '\0';

        for (int i = 0; i < SIZE; i++) {
            diagonal1 += board[i][i];
            diagonal2 += board[i][SIZE - i - 1];

            if ((board[0][i] + board[1][i] + board[2][i]) == playerTotal) {
                return true;
            } else if ((board[i][0] + board[i][1] + board[i][2]) == playerTotal) {
                return true;
            }
        }
        if (diagonal1 == playerTotal || diagonal2 == playerTotal) {
            return true;
        }
        return false;
    }

    private void setBox(int x, int y, char lastPlayer) {
        if (board[x-1][y-1] != '\0') {
            throw new RuntimeException("Box is occupied");
        } else {
            board[x-1][y-1] = lastPlayer;
        }
    }

    private void checkAxis(int axis) {
        if (axis < 1 || axis > 3) {
            throw new RuntimeException("X is outside board");
        }
    }

    public char nextPlayer() {
        if (lastPlayer == 'X') {
            return 'O';
        }
        return 'X';
    }
}

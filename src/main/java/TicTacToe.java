
public class TicTacToe {

    private Character[][] board = {{'O', 'O', 'O'},
                                   {'O', 'O', 'O'},
                                   {'O', 'O', 'O'}};

    private char lastPlayer = 'O';

    public void play(int x, int y) {
        checkAxis(x);
        checkAxis(y);
        setBox(x, y);
        lastPlayer = nextPlayer();
    }

    private void setBox(int x, int y) {
        if (board[x-1][y-1] != 'O') {
            throw new RuntimeException("Box is occupied");
        } else {
            board[x-1][y-1] = 'X';
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

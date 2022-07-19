package abstractdatatypes.tictactoe;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import util.Logger;

import static abstractdatatypes.tictactoe.Constants.FIELDS_ON_BOARD;
import static abstractdatatypes.tictactoe.Constants.ROWS_IN_COLUMN;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
class Board {
    Player[] playersOnField;
    private int moves;
    private static final int[][] FIELDS_IN_ROW = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}
    };
    private static final int[] RESULT_RETURNED_IN_ROW = {1, 3, 6};

    private static final int[][] FIELDS_IN_COLUMN = {
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}
    };
    private static final int[] RESULT_RETURNED_IN_COLUMN = {3, 4, 5};

    private static final int[][] FIELDS_IN_DIAGONAL = {
            {0, 4, 8}, {2, 4, 6}
    };
    private static final int[] RESULT_RETURNED_IN_DIAGONAL = {4, 4};

    static final int DRAW = -1;


    static Board of(Player[] playersOnField) {
        return new Board(playersOnField, 0);
    }

    void prepareBoard() {
        for (int i = 0; i < FIELDS_ON_BOARD; i++) {
            playersOnField[i] = Player.NO_ONE;
        }
    }

    void print() {
        for (int i = 0; i < 9; i++) {
            if (i == 3 || i == 6)
                System.out.println();
            switch (playersOnField[i]) {
                case NO_ONE -> System.out.print(" *  ");
                case BOT -> System.out.print(" X  ");
                case HUMAN -> System.out.print(" O  ");
            }
        }
        System.out.println();
    }

    boolean isFieldTaken(int field) {
        if (field == -1) {
            return true;
        }
        return playersOnField[field] == Player.NO_ONE;
    }

    int isGameFinished() {
        if (checkStatementsOnBoard(FIELDS_IN_ROW[0][0], FIELDS_IN_ROW[0][1], FIELDS_IN_ROW[0][2])) {
            return RESULT_RETURNED_IN_ROW[0];
        }
        if (checkStatementsOnBoard(FIELDS_IN_ROW[1][0], FIELDS_IN_ROW[1][1], FIELDS_IN_ROW[1][2])) {
            return RESULT_RETURNED_IN_ROW[1];
        }
        if (checkStatementsOnBoard(FIELDS_IN_ROW[2][0], FIELDS_IN_ROW[2][1], FIELDS_IN_ROW[2][2])) {
            return RESULT_RETURNED_IN_ROW[2];
        }
        if (checkStatementsOnBoard(FIELDS_IN_COLUMN[0][0], FIELDS_IN_COLUMN[0][1], FIELDS_IN_COLUMN[0][2])) {
            return RESULT_RETURNED_IN_COLUMN[0];
        }
        if (checkStatementsOnBoard(FIELDS_IN_COLUMN[1][0], FIELDS_IN_COLUMN[1][1], FIELDS_IN_COLUMN[1][2])) {
            return RESULT_RETURNED_IN_COLUMN[1];
        }
        if (checkStatementsOnBoard(FIELDS_IN_COLUMN[2][0], FIELDS_IN_COLUMN[2][1], FIELDS_IN_COLUMN[2][2])) {
            return RESULT_RETURNED_IN_COLUMN[2];
        }
        if (checkStatementsOnBoard(FIELDS_IN_DIAGONAL[0][0], FIELDS_IN_DIAGONAL[0][1], FIELDS_IN_DIAGONAL[0][2])) {
            return RESULT_RETURNED_IN_DIAGONAL[0];
        }
        if (checkStatementsOnBoard(FIELDS_IN_DIAGONAL[1][0], FIELDS_IN_DIAGONAL[1][1], FIELDS_IN_DIAGONAL[1][2])) {
            return RESULT_RETURNED_IN_DIAGONAL[1];
        }
        if (moves == FIELDS_ON_BOARD) {
            return DRAW;
        }
        return 0;
    }

    private boolean checkStatementsOnBoard(int firstField, int secondField, int thirdField) {
        return (playersOnField[firstField] == playersOnField[secondField])
                && (playersOnField[secondField] == playersOnField[thirdField])
                && (playersOnField[firstField] != Player.NO_ONE);
    }

    boolean isGameFinished(int result, Player player) {
        return playersOnField[result] == chooseNextPlayer(player) || moves == FIELDS_ON_BOARD;
    }
    Player chooseNextPlayer(Player player) {
        if (player == Player.BOT) {
            return Player.HUMAN;
        } else {
            return Player.BOT;
        }
    }

    boolean isLineEmpty(int line) {
        return ((playersOnField[(line - 1) * 3] == Player.NO_ONE)
                && (playersOnField[(line - 1) * 3 + 1] == Player.NO_ONE)
                && (playersOnField[(line - 1) * 3 + 2] == Player.NO_ONE));
    }

    boolean isLineFull(int line) {
        return !((playersOnField[(line - 1) * 3] == Player.NO_ONE)
                || (playersOnField[(line - 1) * 3 + 1] == Player.NO_ONE)
                || (playersOnField[(line - 1) * 3 + 2] == Player.NO_ONE));
    }

    boolean evaluateRowsForNextPlayer(int line, Player player) {
        return (playersOnField[(line - 1) * ROWS_IN_COLUMN] == chooseNextPlayer(player))
                || (playersOnField[(line - 1) * ROWS_IN_COLUMN + 1] == chooseNextPlayer(player))
                || (playersOnField[(line - 1) * ROWS_IN_COLUMN + 2] == chooseNextPlayer(player));
    }

    boolean evaluateRowsForCurrentPlayer(int line, Player player) {
        return (playersOnField[(line - 1) * ROWS_IN_COLUMN] == player)
                || (playersOnField[(line - 1) * ROWS_IN_COLUMN + 1] == player)
                || (playersOnField[(line - 1) * ROWS_IN_COLUMN + 2] == player);
    }

    boolean isColumnEmpty(int column) {
        return ((playersOnField[column - 1] == Player.NO_ONE)
                && (playersOnField[(column - 1) + 3] == Player.NO_ONE)
                && (playersOnField[(column - 1) + 6] == Player.NO_ONE));
    }

    boolean isColumnFull(int column) {
        return !((playersOnField[column - 1] == Player.NO_ONE)
                || (playersOnField[(column - 1) + 3] == Player.NO_ONE)
                || (playersOnField[(column - 1) + 6] == Player.NO_ONE));
    }

    boolean evaluateColumnsForNextPlayer(int column, Player player) {
        return (playersOnField[column - 1] == chooseNextPlayer(player))
                || (playersOnField[(column - 1) + 3] == chooseNextPlayer(player))
                || (playersOnField[(column - 1) + 6] == chooseNextPlayer(player));
    }

    boolean evaluateColumnsForCurrentPlayer(int column, Player player) {
        return (playersOnField[column - 1] == player)
                || (playersOnField[(column - 1) + 3] == player)
                || (playersOnField[(column - 1) + 6] == player);
    }

    boolean isEmptyFirstDiagonalOfBoard() {
        return ((playersOnField[0] == Player.NO_ONE) && (playersOnField[4] == Player.NO_ONE) && (playersOnField[8] == Player.NO_ONE));
    }

    boolean isFullFirstDiagonalOfBoard() {
        return !((playersOnField[0] == Player.NO_ONE) || (playersOnField[4] == Player.NO_ONE) || (playersOnField[8] == Player.NO_ONE));
    }

    boolean evaluateForFirstCrossWithNextPlayer(Player player) {
        return (playersOnField[0] == chooseNextPlayer(player)) || (playersOnField[4] == chooseNextPlayer(player)) || (playersOnField[8] == chooseNextPlayer(player));
    }

    boolean evaluateForFirstCrossWithCurrentPlayer(Player player) {
        return (playersOnField[0] == player) || (playersOnField[4] == player) || (playersOnField[8] == player);
    }

    boolean isEmptySecondDiagonalOfBoard() {
        return ((playersOnField[2] == Player.NO_ONE) && (playersOnField[4] == Player.NO_ONE) && (playersOnField[6] == Player.NO_ONE));
    }

    boolean isFullSecondDiagonalOfBoard() {
        return !((playersOnField[2] == Player.NO_ONE) || (playersOnField[4] == Player.NO_ONE) || (playersOnField[6] == Player.NO_ONE));
    }

    boolean evaluateDiagonalForNextPlayer(Player player) {
        return ((playersOnField[2] == chooseNextPlayer(player)) || (playersOnField[4] == chooseNextPlayer(player)) || (playersOnField[6] == chooseNextPlayer(player)));
    }

    boolean evaluateDiagonalForCurrentPlayer(Player player) {
        return ((playersOnField[2] == player) || (playersOnField[4] == player) || (playersOnField[6] == player));
    }

    MoveOpportunities getMoveOpportunities() {
        MoveOpportunities moveOpportunities = new MoveOpportunities();
        moveOpportunities.setCpt(-1);
        for (int i = 0; i < FIELDS_ON_BOARD; i++) {
            if (playersOnField[i] == Player.NO_ONE) {
                moveOpportunities.incrementCpt();
                moveOpportunities.getTbl()[moveOpportunities.getCpt()] = i;
            }
        }
        return moveOpportunities;
    }

    Player chooseNextPlayerWithDeepLevel(Player player, int deepLevel) {
        if ((deepLevel % 2) == 0)
            return player;
        else
            return chooseNextPlayer(player);
    }

    void calculate(int deepLevel, Player player, MoveOpportunities moveOpportunities, int i, Board tempBoard) {
        System.arraycopy(playersOnField, 0, tempBoard.playersOnField, 0, FIELDS_ON_BOARD);
        tempBoard.playersOnField[moveOpportunities.getTbl()[i]] = chooseNextPlayerWithDeepLevel(player, deepLevel);
    }

    void executeMove(Player player, int field) {
        Logger.log("Executing move by " + player.name());
        playersOnField[field] = player;
        moves++;
    }

    GameStatus checkGameStatus(Player player) {
        int score = isGameFinished();
        if (score != 0) {
            print();
            Logger.log("*** Game finished ***");
            if (score == -1) {
                Logger.log("Draw.");
                return GameStatus.FINISHED;
            }
            if (player == Player.BOT) {
                Logger.log("You loose.");
            }
            else {
                Logger.log("You won.");
            }
            return GameStatus.FINISHED;
        }
        return GameStatus.PENDING;
    }
}

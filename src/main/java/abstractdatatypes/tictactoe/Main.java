package abstractdatatypes.tictactoe;

import util.Logger;

import java.util.Scanner;

import static abstractdatatypes.tictactoe.Board.DRAW;
import static abstractdatatypes.tictactoe.Constants.*;

class Main {
    private static Scanner scanner;
    private static final int PLUS_INFINITY = 100;
    private static final int MINUS_INFINITY = -100;
    private static final String ALLOWED_CHARS = "012345678";

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        Board board = Board.of(new Player[FIELDS_ON_BOARD]);
        System.out.println("Encoding board's fields");
        System.out.println("0 1 2");
        System.out.println("3 4 5");
        System.out.println("6 7 8");
        board.prepareBoard();
        play(board, setPlayer(args));
    }

    private static void play(Board board, Player player) {
        int field;
        GameStatus gameStatus = GameStatus.PENDING;
        while (gameStatus == GameStatus.PENDING) {
            Logger.log(GameStatus.PENDING.name());
            board.print();
            field = chooseField(player, board);
            if (field != -1) {
                board.executeMove(player, field);
            }
            gameStatus = board.checkGameStatus(player);
            player = board.chooseNextPlayer(player);
        }
    }

    private static int chooseField(Player player, Board board) {
        int field;
        if (player == Player.HUMAN) {
            do {
                Logger.log("Your turn.");
                while (!scanner.hasNextInt()) {
                    Logger.log("This is not a number!");
                    scanner.next();
                }
                field = validField(scanner.nextInt());
                Logger.log("You chosen: " + field);
            } while (!board.isFieldTaken(field));
        } else {
            FieldPlayerMap fieldPlayer = minMax(board, DEEP_LEVEL_ZERO, player);
            field = fieldPlayer.getPlayer();
        }
        return field;
    }

    private static FieldPlayerMap minMax(Board board, int deepLevel, Player player) {
        if (deepLevel == DEEP_OK) {
            return FieldPlayerMap.of(evaluate(board, player), -1);
        }
        MoveOpportunities moveOpportunities = board.getMoveOpportunities();
        if (moveOpportunities.getCpt() == -1) {
            return FieldPlayerMap.of(evaluate(board, player), -1);
        }
        int betterScore = MINUS_INFINITY;
        int playerWithBetterScore = -1;
        for (int i = 0; i <= moveOpportunities.getCpt(); i++) {
            Board tempBoard = Board.of(new Player[FIELDS_ON_BOARD]);
            board.calculate(deepLevel, player, moveOpportunities, i, tempBoard);
            FieldPlayerMap fieldPlayerMap = minMax(tempBoard, deepLevel + 1, player);
            if (-fieldPlayerMap.getScore() > betterScore) {
                betterScore = -fieldPlayerMap.getScore();
                playerWithBetterScore = moveOpportunities.getTbl()[i];
            }
        }
        return FieldPlayerMap.of(betterScore, playerWithBetterScore);
    }

    private static int evaluate(Board board, Player player) {
        int gameResult = board.isGameFinished();
        if (gameResult == DRAW) {
            return gameResult;
        }
        if (gameResult != 0) {
            if (board.isGameFinished(gameResult, player)) {
                return MINUS_INFINITY;
            } else {
                return PLUS_INFINITY;
            }
        }
        int value = 0;
        value = evaluateRows(board, player, value);
        value = evaluateColumns(board, player, value);
        value = evaluateForFirstCross(board, player, value);
        value = evaluateForSecondCross(board, player, value);
        return value;
    }

    private static int evaluateForSecondCross(Board board, Player player, int value) {
        if (!board.isEmptySecondDiagonalOfBoard() || board.isFullSecondDiagonalOfBoard()) {
            if (board.evaluateDiagonalForNextPlayer(player)) {
                value--;
            }
            if (board.evaluateDiagonalForCurrentPlayer(player)) {
                value++;
            }
        }
        return value;
    }

    private static int evaluateForFirstCross(Board board, Player player, int value) {
        if (!board.isEmptyFirstDiagonalOfBoard() || board.isFullFirstDiagonalOfBoard()) {
            if (board.evaluateForFirstCrossWithNextPlayer(player)) {
                value--;
            }
            if (board.evaluateForFirstCrossWithCurrentPlayer(player)) {
                value++;
            }
        }
        return value;
    }

    private static int evaluateColumns(Board board, Player player, int value) {
        for (int column = 1; column <= COLUMNS_IN_ROW; column++) {
            if (!board.isColumnEmpty(column) || board.isColumnFull(column)) {
                if (board.evaluateColumnsForNextPlayer(column, player)) {
                    value--;
                }
                if (board.evaluateColumnsForCurrentPlayer(column, player)) {
                    value++;
                }
            }
        }
        return value;
    }

    private static int evaluateRows(Board board, Player player, int value) {
        for (int line = 1; line <= ROWS_IN_COLUMN; line++) {
            if (!board.isLineEmpty(line) || board.isLineFull(line)) {
                if (board.evaluateRowsForNextPlayer(line, player)) {
                    value--;
                }
                if (board.evaluateRowsForCurrentPlayer(line, player)) {
                    value++;
                }
            }
        }
        return value;
    }

    private static int validField(int field) {
        while (!ALLOWED_CHARS.contains(String.valueOf(field)) || field > 8) {
            Logger.log("Given invalid value.");
            field = scanner.nextInt();
        }
        return field;
    }

    private static Player setPlayer(String[] args) {
        if (args.length == 0 || args[0].equals(Player.BOT.name())) {
            Logger.log(Player.BOT.name() + " is starting game.");
            return Player.BOT;
        }
        Logger.log("You are starting game.");
        return Player.HUMAN;
    }
}

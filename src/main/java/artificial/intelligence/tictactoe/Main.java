package artificial.intelligence.tictactoe;

import util.Logger;

import java.util.Scanner;

import static artificial.intelligence.tictactoe.Constants.*;

class Main {
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        Board board = Board.of(new Player[FIELDS_ON_BOARD]);
        System.out.println("Encoding board's fields");
        System.out.println("1 2 3");
        System.out.println("4 5 6");
        System.out.println("7 8 9");
        board.prepareBoard();
        play(board, setPlayer(args));
        registerInfoFromPlayer();
    }

    private static void play(Board board, Player player) {
        int field;
        GameStatus gameStatus = GameStatus.PENDING;
        while (gameStatus != GameStatus.FINISHED) {
            board.print();
            field = chooseField(player, board);
            if (field != -1) {

            }
            gameStatus = checkGameStaus(board, player);
            player = setNextPlayer();
        }

    }

    private static int chooseField(Player player, Board board) {
        int field;
        if (player == Player.HUMAN) {
            Logger.log("Your turn.");
            do {
                while (!scanner.hasNextInt()) {
                    Logger.log("This is not a number!");
                    scanner.next();
                }
//                field = validField(scanner.nextInt()); todo
                field = scanner.nextInt();
            } while (!board.isFieldTaken(field));
        }
        else {
            FieldPlayerMap fieldPlayer = minMax(board, DEEP_LEVEL_ZERO, player);
        }
    }

    private static FieldPlayerMap minMax(Board board, int deepLevel, Player player) {
        if (deepLevel == DEEP_OK) {
            return FieldPlayerMap.of(, -1);
        }
    }

    private static int validField(int field) {
        while (field < 1 || field > 9) {
            Logger.log("Given invalid value.");
            field = scanner.nextInt();
        }
        return field;
    }

    private static void registerInfoFromPlayer() {
        Logger.log("Press enter.");
        scanner.nextLine();
    }

    private static Player setPlayer(String[] args) {
        if (args.length == 0 || args[0].equals(Player.BOT.name())) {
            Logger.log(Player.BOT.name() + " starting game.");
            return Player.BOT;
        }
        Logger.log(Player.HUMAN.name() + " starting game.");
        return Player.HUMAN;
    }
}

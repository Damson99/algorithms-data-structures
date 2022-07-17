package artificial.intelligence.tictactoe;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import static artificial.intelligence.tictactoe.Constants.FIELDS_ON_BOARD;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor(staticName = "of")
class Board {
    Player[] playersOnField;

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
    }

    boolean isFieldTaken(int field) {
        if (field == -1) {
            return true;
        }
        return playersOnField[field] == Player.NO_ONE;
    }
}

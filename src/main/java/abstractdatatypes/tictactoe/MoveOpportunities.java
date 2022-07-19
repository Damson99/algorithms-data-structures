package abstractdatatypes.tictactoe;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
class MoveOpportunities {
    int cpt;
    int[] tbl = new int[Constants.FIELDS_ON_BOARD];

    void incrementCpt() {
        cpt++;
    }
}

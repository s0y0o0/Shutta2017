import java.util.ArrayList;

public class Game {

    private static Game instance = new Game();

    private Game() {
    }

    static Game getInstance() {
        return instance;
    }

    private ArrayList<Round> _rounds;

    void printGameRecords(){}
}

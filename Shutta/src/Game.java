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

    public void addGameRecord(Round round) {
        _rounds.add(round);
    }

    private ScoreCalculator _scoreCalculator;

    void setStrategy(ScoreCalculator value)
    {
        _scoreCalculator = value;
    }

    void calculate(Player p)
    {
        _scoreCalculator.calculateScore(p);
    }
}

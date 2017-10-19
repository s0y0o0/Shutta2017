import java.util.ArrayList;

public class Game {

    private static Game instance = new Game();

    private Game() {
    }

    static Game getInstance() {
        return instance;
    }

    private ArrayList<Round> _rounds = new ArrayList<>();

    public void printGameRecords()
    {
        double[] statistics = getStatistics();
        System.out.println("Player A: "+ statistics[0] + ", Player B"+ statistics[1]);
    }

    private double[] getStatistics()
    {
        int scoreOfPlayerA = 0, scoreOfPlayerB = 0, total = _rounds.size();
        for (Round round : _rounds) {
            if(round.getWinner() == Winner.PlayerA)
                scoreOfPlayerA++;
            else if(round.getWinner() == Winner.PlayerB)
                scoreOfPlayerB++;
        }
        double[] statistics = {scoreOfPlayerA/total, scoreOfPlayerB/total};
        return statistics;
    }

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

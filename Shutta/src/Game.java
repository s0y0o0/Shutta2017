import java.util.ArrayList;

class Game {

    private static Game instance = new Game();

    private Game() {
    }

    static Game getInstance() {
        return instance;
    }

    private ArrayList<Round> _rounds = new ArrayList<>();

    void printGameRecords()
    {
        int[] statistics = getStatistics();
        int tiedStat = 100-statistics[0]-statistics[1];
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println( "  [ Winner: "+getFinalWinner()+" ] (total " + getRoundCounts()+ " games) Player A : "+ statistics[0] + "%, Player B : "+ statistics[1]+"%, Tied : " + tiedStat+"%");
        System.out.println("---------------------------------------------------------------------------------------");
    }

    private String getFinalWinner()
    {
        Winner winner = _rounds.get(_rounds.size()-1).getWinner();
        switch (winner)
        {
            case PlayerA:
                return "Player A";
            case PlayerB:
                return "Player B";
            default:
                return "None";
        }
    }

    private int getRoundCounts()
    {
        return _rounds.size();
    }


    private int[] getStatistics()
    {
        int[] statistics = new int[2];
        int scoreOfPlayerA = 0, scoreOfPlayerB = 0;
        double total = _rounds.size();
        for (Round round : _rounds) {
            if(round.getWinner() == Winner.PlayerA)
                scoreOfPlayerA++;
            else if(round.getWinner() == Winner.PlayerB)
                scoreOfPlayerB++;
        }
        statistics[0] = (int)(scoreOfPlayerA/total*100);
        statistics[1] = (int)(scoreOfPlayerB/total*100);
        return statistics;
    }

    void addGameRecord(Round round) {
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

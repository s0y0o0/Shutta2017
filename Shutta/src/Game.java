import java.util.ArrayList;

class Game {

    // region class Game declared as a Singleton
    private static Game instance = new Game();
    private Game() {
    }
    static Game getInstance() {
        return instance;
    }
    // endregion

    private ArrayList<Round> _rounds = new ArrayList<>();   // 각 라운드의 정보를 저장하는 ArrayList<>를 하나 생성한다.

    void printGameRecord()
    {
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println(getStringInfo());
        System.out.println("--------------------------------------------------------------------------------------");
    }

    private String getStringInfo()
    {
        int[] scoresInfo = getStatistics();
        int tiedStat = 100-scoresInfo[0]-scoresInfo[1];
        return " [ Winner: "+getFinalWinner()+" ] (total " + getRoundsSize()
                + " games) Player A : "+ scoresInfo[0] + "%, Player B : "+ scoresInfo[1]
                +"%, Tied : " + tiedStat+"%";
    }

    private Winner getFinalWinner()
    {
        return _rounds.get(_rounds.size()-1).getWinner();
    }

    private int getRoundsSize()
    {
        return _rounds.size();
    }

    private int[] getStatistics()
    {
        int[] scoresInfoArray = createScoresInfoArray();
        doStatistics(scoresInfoArray);
        return scoresInfoArray;
    }

    private int[] createScoresInfoArray() {
        int[] scoresInfo = new int[]{0,0};
        for (Round round : _rounds) {
            if(isWinnerA(round))
                scoresInfo[0]++;
            else if(isWinnerB(round))
                scoresInfo[1]++;
        }
        return scoresInfo;
    }

    private boolean isWinnerA(Round round)
    {
        return round.getWinner() == Winner.PlayerA;
    }

    private boolean isWinnerB(Round round)
    {
        return round.getWinner() == Winner.PlayerB;
    }

    private void doStatistics(int[] statistics) {
        double total = getRoundsSize();
        statistics[0] = (int)(statistics[0]/total*100);
        statistics[1] = (int)(statistics[1]/total*100);
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

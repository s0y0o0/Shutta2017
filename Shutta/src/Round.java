public class Round {
    private int _roundNum;

    //region Winner _winner
    private Winner _winner;

    public Winner getWinner() {
        return _winner;
    }

    public void setWinner(int score1, int score2) {
        if (score1>score2)
            _winner = Winner.PlayerA;
        else if (score1<score2)
            _winner = Winner.PlayerB;
        else
            _winner = Winner.None;
    }

    //endregion
    void printRecord(){}
}

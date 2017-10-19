public class Round {
    private static int _roundNum = 0;

    //region Winner _winner
    private Winner _winner;

    public Winner getWinner() {
        return _winner;
    }

    public void setWinner(Player p1, Player p2) {
        if (p1.getScore()>p2.getScore())
            _winner = Winner.PlayerA;
        else if (p1.getScore()<p2.getScore())
            _winner = Winner.PlayerB;
        else
            _winner = Winner.None;
        _roundNum ++;

    }

    //endregion
    void printRoundRecord(){}
}

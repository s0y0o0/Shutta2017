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
    void printRound(Player p1, Player p2) {
        System.out.println("************************* " + _roundNum + "번째 게임입니다 *************************");
        System.out.println("배팅액 : " + Dealer.getInstance().getBettingMoney());
        System.out.println("Player A: " + p1.getPlayerCardInfo() + " / 남은금액 : " + p1.getMoney() );
        System.out.println("Player B: " + p2.getPlayerCardInfo() + " / 남은금액 : " + p2.getMoney() );
        System.out.println("Winner: " + _winner);
    }
}

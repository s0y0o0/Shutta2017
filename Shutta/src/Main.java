public class Main {
    public static void main(String[] args) {

        Player p1 = new Player();
        Player p2 = new Player();

        boolean isTied = false;
        BettingMoney bettingMoney = new BettingMoney();

        while(isRunning(p1, p2)) {
            Round round = new Round();
            //배팅액 받기
            bettingMoney.betMoney(p1, p2, isTied);
            Dealer.getInstance().pickCards(p1, p2);

            if (isTied)
                Game.getInstance().setStrategy(new TieScoreCalculator());
            else
                Game.getInstance().setStrategy(new OriginalCardPair());

            Game.getInstance().calculate(p1);
            Game.getInstance().calculate(p2);

            round.setWinner(p1, p2);

            //배팅액분배
            bettingMoney.attributeMoney(p1, p2, round.getWinner());

            isTied = judgeTie(round);
            Game.getInstance().addGameRecord(round);

            round.printRoundRecord();
        }

        Game.getInstance().printGameRecords();
    }

    // 전 판이 무승부인 경우
    public static boolean judgeTie(Round round){
        boolean isTied;
        if(round.getWinner() == Winner.None)
            isTied = true;
        else
            isTied = false;
        return isTied;
    }

    public static boolean isRunning(Player p1, Player p2){
       if(p1.getMoney() <= 0 || p2.getMoney() <= 0)
           return false;
       return true;
    }

}

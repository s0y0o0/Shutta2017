public class Main {
    public static void main(String[] args) {

        Player p1 = new Player();
        Player p2 = new Player();

        boolean isTied = false;

        while(isRunning(p1, p2)) {
            Round round = new Round();
            //배팅액 받기
            Dealer.getInstance().betMoney(p1, p2, isTied);
            Dealer.getInstance().pickCards(p1, p2);

            if (isTied)
                Game.getInstance().setStrategy(new TieScoreCalculator());
            else
                Game.getInstance().setStrategy(new OriginalScoreCalculator());

            Game.getInstance().calculate(p1);
            Game.getInstance().calculate(p2);

            round.setWinner(p1, p2);

            //배팅액분배
            Dealer.getInstance().attributeMoney(p1, p2, round.getWinner());

            isTied = judgeTie(round);
            Game.getInstance().addGameRecord(round);

            round.printRound(p1, p2);
        }

        Game.getInstance().printGameRecords();
    }

    // 전 판이 무승부인 경우
    private static boolean judgeTie(Round round){
        return round.getWinner() == Winner.None;
    }

    private static boolean isRunning(Player p1, Player p2){
       return p1.getMoney() > 0 && p2.getMoney() > 0;
    }

}

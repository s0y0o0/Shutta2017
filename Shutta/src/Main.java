public class Main {
    public static void main(String[] args) {

        Player p1 = new Player(); //플레이어1 생성
        Player p2 = new Player(); //플레이어1 생성

        boolean isTied = false; //게임시작 전 무승부 여부의 초기값 설정


        while(isRunning(p1, p2)) {
            Round round = new Round();
            //배팅액 받기
            Dealer.getInstance().betMoney(p1, p2, isTied);
            Dealer.getInstance().pickCards(p1, p2);

            if (isTied) //전판이 무승부인지
                Game.getInstance().setStrategy(new TieIScoreCalculator()); //무승부인경우
            else
                Game.getInstance().setStrategy(new OriginalIScoreCalculator());//기본 점수계산

            Game.getInstance().calculate(p1); //playA의 점수 계산
            Game.getInstance().calculate(p2); //playB의 점수 계산

            round.setWinner(p1, p2); //누가 우승했는지 판별

            //배팅액분배
            Dealer.getInstance().attributeMoney(p1, p2, round.getWinner());

            isTied = judgeTie(round); // 해당 게임이 무승부인지 판별
            Game.getInstance().addGameRecord(round); // Game 클레스에 현재 round 결과 저장

            round.printRound(p1, p2); //해당 round 결과 출력
        }

        Game.getInstance().printGameRecord(); //한명이 파산할 때 까지의 축적된 결과를 출력
    }

    // 전 판이 무승부인 경우
    private static boolean judgeTie(Round round){
        return round.getWinner() == Winner.None;
    }
    //파산자가 있는지 판별
    private static boolean isRunning(Player p1, Player p2){
       return p1.getMoney() > 0 && p2.getMoney() > 0;
}

}

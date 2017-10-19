public class BettingMoney {

    int money = 200; //배팅액 초기값

    // 1. 각각의 플레이어의 소지금에서 배팅 금액 빼기
    public void betMoney(Player p1 , Player p2, boolean tie){
        judgeBettingMoney(tie);
        p1.setMoney(p1.getMoney() - money/2);
        p2.setMoney(p2.getMoney() - money/2);
    }
    // 2. 전 판이 무승부인 경우
    private void judgeBettingMoney(boolean tie){
        if(tie)
            money = money * 2;
        else
            money = 200;
    }

    // 3. 게임이 끝난 후 이긴 플레이어에게 배팅액 분배
    public void attributeMoney(Player p1, Player p2, Winner winner){
        if(winner == Winner.PlayerA) {
            p1.setMoney(p1.getMoney() + money);
        }
        else if (winner == Winner.PlayerB){
            p2.setMoney(p2.getMoney() + money);
        }
    }
}

public class BettingMoney {

    int money = 100; //배팅액 초기값
    int playAMoney  ; //플레이어 A의 소지 금액
    int playBMoney ; //플레이어 B의 소지 금액
    boolean tie = false; //전 판이 무승부였는지

    // 1. 각각의 플레이어의 소지금에서 배팅 금액 빼기
    private void subtractionMoney(){

    }

    // 2. 전 판이 무승부인 경우
    private int judgeTie(){
        if(tie==true) money = money * 2;

        return money;
    }

    // 3. 게임이 끝난 후 이긴 플레이어에게 배팅액 분배
    private void attributeMoney(){

    }
}

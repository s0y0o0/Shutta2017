package playerPackage;

import cardPackage.Card;

public class Player{
    //region Card _card1, 플레이어가 현재 라운드에서 받은 첫 번째 카드
    private Card _card1;
    public Card getCard1() {
        return _card1;
    }
    public void setCard1(Card card1) {
        _card1 = card1;
    }
    //endregion

    //region Card _card2, 플레이어가 현재 라운드에서 받은 두 번째 카드
    private Card _card2;
    public Card getCard2() {
        return _card2;
    }
    public void setCard2(Card card2) {
        _card2 = card2;
    }
    //endregion

    //region int _score, 플레이어의 현재 라운드의 두 카드로부터 계산된 스코어
    private int _score;
    public int getScore() {
        return _score;
    }
    public void setScore(int score) {
        _score = score;
    }
    //endregion

    //region int _money, 플레이어의 현재 잔고
    private int _money = 1000;
    public int getMoney() {
        return _money;
    }
    public void setMoney(int money) {
        _money = money;
    }
    //endregion

    public String getPlayerCardInfo() // 플레이어의 카드 정보를 문자열로 반환하는 메소드.
    {
        return _card1.getCardInfo()+ " / " + _card2.getCardInfo();
    }

}

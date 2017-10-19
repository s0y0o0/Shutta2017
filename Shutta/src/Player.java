public class Player {
    //region Card _card1
    private Card _card1;

    public Card getCard1() {
        return _card1;
    }

    public void setCard1(Card card1) {
        _card1 = card1;
    }

    //endregion

    //region Card _card2
    private Card _card2;

    public Card getCard2() {
        return _card2;
    }

    public void setCard2(Card card2) {
        _card2 = card2;
    }
    //endregion

    //region int _score
    private int _score;

    public int getScore() {
        return _score;
    }

    public void setScore(int score) {
        _score = score;
    }
    //endregion

    //region int _money
    private int _money = 1000;

    public int getMoney() {
        return _money;
    }

    public void setMoney(int money) {
        _money = money;
    }
    //endregion

    public String getPlayerCardInfo()
    {
        return _card1.getCardInfo()+ " / " + _card2.getCardInfo();
    }


}

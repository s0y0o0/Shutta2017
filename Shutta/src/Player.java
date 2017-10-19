public class Player {
    //region CardPair _cardPair
    private CardPair _cardPair;

    public CardPair getCardPair() {
        return _cardPair;
    }

    public void setCardPair(Card[] cards) {
        _cardPair.setCard1(cards[0]);
        _cardPair.setCard2(cards[1]);
    }
    //endregion

    //region int _money
    private int _money;

    public int getMoney() {
        return _money;
    }

    public void setMoney(int money) {
        _money = money;
    }
    //endregion

}

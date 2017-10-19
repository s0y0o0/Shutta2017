public class CardPair {
    //region Card[] _cardPair
    private Card[] _cardPair;

    public Card[] getCardPair() {
        return _cardPair;
    }

    public void setCardPair(Card[] cardPair) {
        _cardPair = cardPair;
    }
    //endregion

    class Card {
        //region int _num
        private int _num;

        public int getNum() {
            return _num;
        }

        public void setNum(int num) {
            _num = num;
        }
        //endregion

        //region boolean _gwang
        private boolean _gwang;

        public boolean getGwang() {
            return _gwang;
        }

        public void setGwang(boolean gwang) {
            _gwang = gwang;
        }
        //endregion

    }

}

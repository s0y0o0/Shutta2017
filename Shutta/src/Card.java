public class Card {
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

    public String getCardInfo()
    {
        String cardInfo = "Card: No. "+_num;
        if(_gwang == true)
            cardInfo = cardInfo + " (Gwang) ";
        return cardInfo;
    }
}
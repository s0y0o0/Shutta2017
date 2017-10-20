class Card {

    //region int _num
    private int _num;   // 카드의 번호를 저장.
    int getNum() {
        return _num;
    }
    void setNum(int num) {
        _num = num;
    }
    //endregion

    //region boolean _gwang
    private boolean _gwang; // 카드가 광 카드인지 아닌지를 저장.
    boolean getGwang() {
        return _gwang;
    }
    void setGwang(boolean gwang) {
        _gwang = gwang;
    }
    //endregion

    String getCardInfo()    //  카드의 정보를 문자열로 반환. 각 라운드에서 카드의 정보를 출력할 때 사용한다.
    {
        String cardInfo = "Card: No. "+_num;
        if(_gwang)
            cardInfo = cardInfo + " (Gwang) ";
        return cardInfo;
    }
}
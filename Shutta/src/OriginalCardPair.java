public class OriginalCardPair extends ScoreCalculator {
    private Card _card1;
    private Card _card2;

    public void calculateScore(Player player){

        _card1 = player.getCard1();
        _card2 = player.getCard2();

        if(isGwang()){ // 광땡일때
            player.setScore(21);
        }else if(isJang()){ // 장땡일때
            player.setScore(20);
        }else if(isDdeng()){ // 땡 일때
            player.setScore(calculateDdeng(_card1.getNum()));
        }else{ //끗일때
            player.setScore((_card1.getNum()+_card2.getNum())%10);
        }
    }
    boolean isGwang(){
        if(_card1.getGwang() == true && _card2.getGwang() == true)
            return true;
        else return false;
    }
    boolean isJang(){
        if(_card1.getNum() == 10 && _card2.getNum() == 10) return true;
        else return false;
    }
    boolean isDdeng(){
        if(_card1.getNum() == _card2.getNum()) return true;
        else return false;
    }
    int calculateDdeng(int cardNumber1){
        return cardNumber1+9;
    }
}

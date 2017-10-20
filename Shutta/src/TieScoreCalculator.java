public class TieScoreCalculator implements IScoreCalculator {
    private Card _card1;
    private Card _card2;

    public void calculateScore(Player player){

        _card1 = player.getCard1();
        _card2 = player.getCard2();

        if(isGwang()){ // 광땡일때
            player.setScore(20);
        }else if(isJang()){ // 장땡일때
            player.setScore(21);
        }else if(isDdeng()){ // 땡 일때
            player.setScore(calculateDdeng(_card1.getNum()));
        }else{ //끗일때
            player.setScore((_card1.getNum()+_card2.getNum())%10);
        }
    }
    private boolean isGwang(){ // 광땡일 때 true return
        return _card1.getGwang() && _card2.getGwang();
    }
    private boolean isJang(){ // 장땡일때 true return
        return _card1.getNum() == 10 && _card2.getNum() == 10;
    }
    private boolean isDdeng(){ // 땡일때 true return
        return _card1.getNum() == _card2.getNum();
    }
    private int calculateDdeng(int cardNumber1){ //땡일 때 점수 계산
        return cardNumber1+9;
    }
}

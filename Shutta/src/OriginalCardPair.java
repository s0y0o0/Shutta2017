public class OriginalCardPair extends ScoreCalculator {

    public int calculateScore(Player player){
        int CardNumber1 = player.getCard1().getNum();
        int CardNumber2 = player.getCard2().getNum();
        boolean CardGwang1 = player.getCard1().getGwang();
        boolean CardGwang2 = player.getCard2().getGwang();

        if(CardGwang1 == true && CardGwang2 == true){ // 광땡일때
            player.setScore(21);
        }else if(CardNumber1 == 10 && CardNumber2 == 10){ // 장땡일때
            player.setScore(20);
        }else if(CardNumber1 == CardNumber2){ // 땡 일때

        }else{ //끗일때
            player.setScore((CardNumber1+CardNumber2)%10);
        }


        int score = 0;
        player.setScore(score);

        return 0;
    }
}

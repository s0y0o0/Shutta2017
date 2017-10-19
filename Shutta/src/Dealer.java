import java.util.HashSet;
import java.util.Random;

public class Dealer {

    // betting money
    //region int _bettingMoney
    private int _bettingMoney=200;
    public int getBettingMoney() {
        return _bettingMoney;
    }
    //endregion

    // 각각의 플레이어의 소지금에서 배팅 금액 빼기
    public void betMoney(Player p1 , Player p2, boolean tie){
        judgeBettingMoney(tie);
        p1.setMoney(p1.getMoney() - _bettingMoney /2);
        p2.setMoney(p2.getMoney() - _bettingMoney /2);
    }
    // 전 판이 무승부인 경우
    private void judgeBettingMoney(boolean tie){
        if(tie)
            _bettingMoney = _bettingMoney * 2;
        else
            _bettingMoney = 200;
    }

    //  게임이 끝난 후 이긴 플레이어에게 배팅액 분배
    public void attributeMoney(Player p1, Player p2, Winner winner){
        if(winner == Winner.PlayerA)
            p1.setMoney(p1.getMoney() + _bettingMoney);
        else if (winner == Winner.PlayerB)
            p2.setMoney(p2.getMoney() + _bettingMoney);
        else{
            p1.setMoney(p1.getMoney()+_bettingMoney/2);
            p2.setMoney(p2.getMoney()+_bettingMoney/2);
        }
    }
    //betting money


    private static Dealer instance = new Dealer();

    private Dealer() {
    }

    static Dealer getInstance() {
        return instance;
    }

    public void pickCards(Player p1, Player p2)
    {
        Card[] randCards = getRandCards();

        setPlayerCards(p1, randCards[0], randCards[1]);
        setPlayerCards(p2, randCards[2], randCards[3]);
    }

    private void setPlayerCards(Player player, Card card1, Card card2)
    {
        player.setCard1(card1);
        player.setCard2(card2);
    }

    private static Random _random = new Random();

    private Card[] getRandCards()
    {
        int[] randNumbers = getRandNumbers();
        Card[] randCards = new Card[4];
        for(int i=0; i<4; i++)
        {
            randCards[i] = convertIntToCard(randNumbers[i]);
        }
        return  randCards;
    }

    private Card convertIntToCard(int randNumber) {
        Card card = new Card();
        card.setNum((randNumber-1)%10+1);
        if(randNumber == 1 || randNumber == 3 || randNumber == 8 )
            card.setGwang(true);
        else
            card.setGwang(false);
        return card;
    }

    private int[] getRandNumbers()
    {
        int[] randNumbers = new int[4];
        HashSet<Integer> setOfRandNumbers = new HashSet<>();
        int i = 0;
        while(setOfRandNumbers.size()<4)
        {
            int rand = _random.nextInt(20) + 1;
            setOfRandNumbers.add(rand);
            if(i != setOfRandNumbers.size())
                randNumbers[i++] = rand;
        }
        return randNumbers;
    }
}

package mainPackage;

import cardPackage.Card;
import cardPackage.Deck;
import playerPackage.Player;

import java.util.HashSet;
import java.util.Random;

class Dealer {

    // region class mainPackage.Dealer declared as a Singleton
    private static Dealer instance = new Dealer();
    private Dealer() {}
    static Dealer getInstance() {
        return instance;
    }
    //endregion

    private static Random _random = new Random();  // 랜덤으로 숫자를 뽑을 때 사용할 랜덤 변수를 생성한다.
    private HashSet<Integer> setOfRandNumbers = new HashSet<>();   // 숫자 1~20을 중복되지 않게 뽑기 위해 HashSet<>을 생성한다.

    //region int _bettingMoney
    private int _bettingMoney=200;
    int getBettingMoney() {
        return _bettingMoney;
    }
    //endregion

    // 각각의 플레이어의 소지금에서 배팅 금액 빼기
    void betMoney(Player p1 , Player p2, boolean tie){
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
    void attributeMoney(Player p1, Player p2, Winner winner){
        if(winner == Winner.PlayerA)
            p1.setMoney(p1.getMoney() + _bettingMoney);
        else if (winner == Winner.PlayerB)
            p2.setMoney(p2.getMoney() + _bettingMoney);
        else{
            p1.setMoney(p1.getMoney()+_bettingMoney/2);
            p2.setMoney(p2.getMoney()+_bettingMoney/2);
        }
    }

    void pickCards(Player p1, Player p2)   // 딜러가 플레이어 두 명에게 각각 카드를 두 장씩 나누어준다.
    {
        Card[] randCards = getRandCards(); // getRandCards() 함수를 사용하여 카드 네 장을 저장하는 배열 randCards[]를 얻는다.

        setPlayerCards(p1, randCards[0], randCards[1]);    // 첫 번째 플레이어에게 카드 두 장을 나누어준다.
        setPlayerCards(p2, randCards[2], randCards[3]);    // 두 번째 플레이어에게 카드 두 장을 나누어준다.
    }

    private void setPlayerCards(Player player, Card card1, Card card2) // 플레이어 내부에 카드 두 장을 저장하는 메소드이다.
    {
        player.setCard1(card1);    // 첫 번째 카드를 플레이어의 _card1에 저장한다.
        player.setCard2(card2);    // 두 번째 카드를 플레이어의 _card2에 저장한다.
    }

    private Card[] getRandCards()  // 카드 네 장을 랜덤하게 뽑아서 카드 네 장을 저장한 배열을 반환한다.
    {
        Card[] randCards = new Card[4];    // 카드 네 장을 저장하는 배열 randCards[]를 생성한다.
        saveRandCards(randCards);  // 카드 네 장을 랜덤하게 뽑아서 randCards[]에 저장한다.
        return randCards;  // randCards 를 반환한다.
    }

    private void saveRandCards(Card[] randCards)
    {
        int i = 0; // 정수형 변수 i는 현재 randCards[]에 저장된 카드의 갯수를 나타낸다.
        while(setOfRandNumbers.size()<4)   // HashSet<>의 크기가 4개가 될 때까지 while 문을 반복한다.
        {
            int rand = getRandNumBetween0And19();  // 0~19까지 랜덤한 숫자를 하나 생성한다.
            if(setOfRandNumbers.add(rand)) // 만약 중복이 없다면, 방금 생성한 숫자를 HashSet<>에 추가한다. 만약 숫자가 하나 추가되면,
                randCards[i++] = Deck.getInstance().getCardFromDeck(rand);   // 새로 추가된 숫자에 해당하는 카드를 덱에서 가져와 randCards[]에 저장한다.
        }
        setOfRandNumbers.clear();  // HashSet<> 개체에서 모든 요소를 제거하여 초기화한다.
    }

    private int getRandNumBetween0And19()
    {
        return _random.nextInt(20);
    }

}

import java.util.HashSet;
import java.util.Random;

 class Dealer {

     // region class Dealer declared as a Singleton
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
         Card[] randCards = getRandCards(); // getRandCards() 함수를 사용하여 카드 네 장을 저장하는 배열 randCards 생성한다.

         setPlayerCards(p1, randCards[0], randCards[1]);    // 첫 번째 플레이어에게 카드 두 장을 나누어준다.
         setPlayerCards(p2, randCards[2], randCards[3]);    // 두 번째 플레이어에게 카드 두 장을 나누어준다.
     }

     private void setPlayerCards(Player player, Card card1, Card card2) // 플레이어 내부에 카드 두 장을 저장하는 함수이다.
     {
         player.setCard1(card1);    // 첫 번째 카드를 플레이어의 _card1에 저장한다.
         player.setCard2(card2);    // 두 번째 카드를 플레이어의 _card2에 저장한다.
     }

     private Card[] getRandCards()  // 카드 네 장을 랜덤하게 뽑아서 반환한다.
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
             int rand = getRandNumBetween1And20();  // 1~20까지 랜덤한 숫자를 하나 생성한다.
             if(setOfRandNumbers.add(rand)) // 만약 중복이 없다면, 방금 생성한 숫자를 HashSet<>에 추가한다. 만약 숫자가 하나 추가되면,
                 randCards[i++] = convertIntToCard(rand);   // 새로 추가된 숫자를 카드로 변환하여 randCards[]에 저장한다.
         }
         setOfRandNumbers.clear();  // HashSet<> 개체에서 모든 요소를 제거하여 초기화한다.
     }

     private int getRandNumBetween1And20()
     {
         return _random.nextInt(20)+1;
     }

     private Card convertIntToCard(int randNumber) {    // 1~20까지의 숫자를 카드로 반환하는 함수이다.
         Card card = new Card();                // 새로운 카드를 생성한다.
         card.setNum(getCardNum(randNumber));   // 카드에 번호를 저장한다.
         card.setGwang(isCardGwang(randNumber));    // 카드가 광인지 아닌지 여부를 저장한다.
         return card;                           // 카드를 반환한다.
     }

     private int getCardNum(int number) // 1~20의 숫자를 인자로 받아서 1~10의 숫자로 반환하는 함수이다.
     {
         return (number-1)%10+1;    // 1~10까지는 그대로, 11~20는 1~10으로 반환된다.
     }

     private boolean isCardGwang(int number)    // 1~20의 숫자를 인자로 받아서 해당 카드가 광인지 아닌지 여부를 반환한다.
     {
         return number == 1 || number == 3 || number == 8;  // 랜덤으로 생성된 숫자가 1, 3, 8 중에 하나이면 참을 반환한다.
     }
 }

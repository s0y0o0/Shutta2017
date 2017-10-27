package cardPackage;

import java.util.stream.IntStream;

public class Deck {

    private static Deck instance = new Deck();

    private Deck() {
        _deck = new Card[20];
        IntStream.range(0, 20).forEachOrdered(index -> _deck[index] = convertIntToCard(index));
    }

    public static Deck getInstance() {
        return instance;
    }

    private Card[] _deck;

    public Card getCardFromDeck(int i)
    {
        return _deck[i];
    }

    private Card convertIntToCard(int index) {    // 0~19까지의 숫자를 카드로 반환하는 메소드이다.
        Card card = new Card();                // 카드를 하나 생성한다.
        card.setNum(getCardNum(index));   // 카드에 번호를 저장한다.
        card.setGwang(isCardGwang(index));    // 카드가 광인지 아닌지 여부를 저장한다.
        return card;                           // 카드를 반환한다.
    }

    private int getCardNum(int index) // 0~19의 숫자를 인자로 받아서 1~10의 숫자로 반환하는 메소드이다.
    {
        return index%10+1;    // 0~9까지는 1을 더해 1~10으로 반환되고, 10~19는 1~10으로 반환된다.
    }

    private boolean isCardGwang(int index)    // 0~19의 숫자를 인자로 받아서 해당 카드가 광인지 아닌지 여부를 반환한다.
    {
        index++;   // 인자로 받은 숫자로부터 카드 번호를 보다 직관적으로 이해하기 위해 인자로 받은 숫자에 1을 더한다.
        return index == 1 || index == 3 || index == 8;  // 카드 번호가 1, 3, 8 인 카드 중에 하나씩만 광을 반환한다.
    }
}
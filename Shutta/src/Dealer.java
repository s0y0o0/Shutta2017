import java.util.HashSet;
import java.util.Random;

public class Dealer {

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
        HashSet<Integer> randNumbers = getRandNumbers();
        Card[] randCards = new Card[4];
        int i = 0;
        for (int item : randNumbers) {
            randCards[i] = convertIntToCard(item);
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

    private HashSet<Integer> getRandNumbers()
    {
        HashSet<Integer> setOfRandNumbers = new HashSet<>();
        //int[] randNumbers = new int[4];
        //int i = 0;
        while(setOfRandNumbers.size()<4)
        {
            int rand = _random.nextInt(20) + 1;
            setOfRandNumbers.add(rand);
            //if(i != setOfRandNumbers.size())
            //    randNumbers[i++] = rand;
        }
        return  setOfRandNumbers;//randNumbers;
    }
}

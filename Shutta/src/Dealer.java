import java.util.HashSet;
import java.util.Random;

public class Dealer {
    void pickCards(Player p1, Player p2)
    {

        //p1.setCardPair();
        //p2.setCardPair();
    }

    private static Random _random = new Random();

    HashSet<Integer> pickRandNums(int size, int bound)
    {
        HashSet<Integer> randNumbers = new HashSet<>();
        while(randNumbers.size()<size)
        {
            int rand = _random.nextInt(bound) + 1;
            randNumbers.add(rand);
        }
        return randNumbers;
    }
}

import java.util.HashSet;
import java.util.Random;

public class Dealer {


    private static Dealer instance = new Dealer();

    private Dealer() {
    }

    static Dealer getInstance() {
        return instance;
    }

    void pickCards(Player p1, Player p2)
    {

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

public class Main {
    public static void main(String[] args) {

        Player p1 = new Player();
        Player p2 = new Player();

        //while
        Round round = new Round();

        Dealer.getInstance().pickCards(p1, p2);

        int score1 = p1.getCardPair().calculateScore();
        int score2 = p2.getCardPair().calculateScore();

        round.setWinner(score1, score2);



        //Game.getInstance().add(round);


        /*
        Card c1 = new Card();
        c1.setGwang(true);
        c1.setNum(10);

        Card c2 = new Card();
        c2.setGwang(false);
        c2.setNum(1);

        CardPair cp= new OriginalCardPair();

        */
    }
}

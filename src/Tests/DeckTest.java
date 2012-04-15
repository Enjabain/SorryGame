import sorryGame.Deck;

/**
 * CS 110 Program: DeckTest
 * Programmer: Christopher Morse
 * Date: 4/4/11
 */
public class DeckTest {
    /**
     * Tests the deck Class.
     *
     * @param args
     */
    public static void main(String[] args) {
        Deck testDeck = new Deck();
        System.out.println(testDeck);
        testDeck.shuffle();
        System.out.println(testDeck);
        for (int i = 0; i < 5; i++) {
            System.out.println(testDeck.getCard());
        }
        testDeck.shuffle();
        System.out.println(testDeck);
        for (int i = 0; i < 5; i++) {
            System.out.println(testDeck.getCard());
        }
        Deck deck = new Deck();
        System.out.println(deck);
        for (int i = 0; i < (2 * deck.DECK_SIZE); i++) {
            System.out.println(deck.getCard());
            System.out.println(deck);
        }
    }
}

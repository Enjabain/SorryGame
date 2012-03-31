package sorryGame;

import java.util.*;

/**
 * CS 205 Program: Deck
 * Programmer: Christopher Morse
 * Date: 3/31/2012
 *
 * Card deck class inplements Array based list for constructing the "deck".  Uses a hashmap to map point values to cards.
 */
@SuppressWarnings("UnusedDeclaration") public class Deck {

    public static final int[] CARD_RANK = {0, 1, 2, 3, 4, 5, 7, 8, 10, 11, 12};
    public final int DECK_SIZE = 44;

    List<Card> deck;
    Card topCard;

    public Deck() {
        makeDeck();
    }

    private void makeDeck() {
        deck = new ArrayList<Card>(DECK_SIZE);
        for (int i = 0; i < 4; i++){
            for (int card : CARD_RANK) {
                    deck.add(new Card(card));
            }
        }
        ((ArrayList) deck).trimToSize();
        shuffle();
    }

    /**
     * Implements a ListIterator to return the top card from the deck List, and removes the returned card from the deck.
     * If the deck is empty 'makeDeck()' is called to refresh the deck and then 'getCard()' is called recurssively.
     * @return topCard
     * Top Card object from the deck.
     */
    public Card getCard() {
        ListIterator<Card> deckIterator = deck.listIterator();
        if (deckIterator.hasNext()){
            topCard = deckIterator.next();
            deckIterator.remove();
        }
        else{
            this.makeDeck();
            topCard = this.getCard();
        }
        return topCard;
    }

    /**
     * Shuffles the deck of cards using Random numbers. Moves through the entire deck, from back to front, taking a random card
     * from the unshuffled portion of the deck and placing it at the head of the shuffled section of the deck.
     */
    public void shuffle() {
        Random random = new Random();
        for (int i = deck.size(); i > 0; i--) {
            int movedCardIndex = random.nextInt(i);
            Card card = deck.get(movedCardIndex);
            deck.add((i), card);
            deck.remove(movedCardIndex);
        }
    }// shuffle

    /**
     * To string method uses iterator to create String of the entire deck by calling each individual Card's toString method
     * and appending to the deckString.
     * @return deckString.toString()
     * String of StringBuffer deckString.
     */
    public String toString() {
        StringBuilder deckString = new StringBuilder();
        for (Card aDeck : deck) {
            String nextCard = aDeck.toString();
            deckString.append(nextCard).append(" ");
        }
        return deckString.toString();
    }

    /**
     * CS 205
     * Program: Card
     * Programmer: Christopher Morse
     * Date: 3/31/2012
     */
    public static class Card {
        private int rank;

        public Card(Integer rank) {
            setRank(rank);
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public int getRank() {
            return rank;
        }

        @Override
        public String toString() {
            String cardString = "";
            if( this.rank == 0){ return "sorry"; }
            return Integer.toString(this.rank);
        }
    }

    /**
     * Test method for Deck and Card classes. Creates a deck, prints it, then retuns the next card from the top of the
     * deck until empty.
     * @param args null argument.
     */
    public static void main(String[] args) {
        Deck deck = new Deck();
        System.out.println(deck);
        for (int i = 0; i < (2 * deck.DECK_SIZE); i++) {
            System.out.println(deck.getCard());
            System.out.println(deck);
        }
    }
}

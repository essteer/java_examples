import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Hand implements Comparable<Hand> {

    private ArrayList<Card> hand;

    public Hand() {
        this.hand = new ArrayList<>();
    }

    public void add(Card card) {
        if (!(this.hand.contains(card))) {
            this.hand.add(card);
        }
    }

    public void print() {
        Iterator<Card> iterator = this.hand.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
    }

    public void sort() {
        // sorts the cards in the hand
        // after sorting, the cards are printed in order
        ArrayList<Card> sortHand = this.hand;
        Comparator<Card> comparator = Comparator.comparing(Card::getValue).thenComparing(Card::getSuit);
        Collections.sort(sortHand, comparator);

        sortHand.stream().map(card -> card.toString())
                .forEach(card -> System.out.println(card));

    }

    public void sortBySuit() {
        // sorts the cards in the hand by suit then value order
        // after sorting, the cards are printed in order
        ArrayList<Card> sortHand = this.hand;
        Comparator<Card> comparator = Comparator.comparing(Card::getSuit).thenComparing(Card::getValue);
        Collections.sort(sortHand, comparator);

        sortHand.stream().map(card -> card.toString())
                .forEach(card -> System.out.println(card));

    }

    private int sumOfValues() {
        int sum = 0;
 
        for (Card card : hand) {
            sum += card.getValue();
        }
 
        return sum;
    }
 
    @Override
    public int compareTo(Hand hand) {
        return this.sumOfValues() - hand.sumOfValues();
    }

}

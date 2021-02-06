import java.util.*;

public class DeckOfCards {
    private Card top;
    public DeckOfCards() {
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                Card c = new Card(i + 1, suits[j]);
                c.setNext(this.top);
                this.top = c;
            }
        }
        shuffle();
    }

    public void shuffle() {
        Random r = new Random();
        for (int i = 0; i < Math.abs((r.nextInt() % 20) + 100); i++) {
            Card c = this.top;
            for (int j = 0; j < Math.abs(r.nextInt() % 51) + 1; j++) {
                c = c.getNext();
            }
            if (c.getPrev() != null) {
                c.getPrev().setNext(c.getNext());
            }
            c.setNext(this.top);
            this.top = c;
        }

        for (int i = 0; i < Math.abs((r.nextInt() % 20) + 100); i++) {
            Card c = this.top;
            for (int j = 0; j < Math.abs(r.nextInt() % 25) + 26; j++) {
                c = c.getNext();
            }
            if (c.getPrev() != null) {
                c.getPrev().setNext(c.getNext());
            }
            c.setNext(this.top);
            this.top = c;
        }

        for (int i = 0; i < Math.abs((r.nextInt() % 20) + 100); i++) {
            Card c = this.top;
            for (int j = 0; j < Math.abs(r.nextInt() % 9) + 43; j++) {
                c = c.getNext();
            }
            if (c.getPrev() != null) {
                c.getPrev().setNext(c.getNext());
            }
            c.setNext(this.top);
            this.top = c;
        }
    }

    public void printDeck() {
        Card c = this.top;
        while (c != null) {
            // c.print();
            c = c.getNext();
        }
    }

    public Card draw() {
        Card c = this.top;
        this.top = c.getNext();;
        return c;
    }

    public static void main(String[] args) {
        DeckOfCards deck = new DeckOfCards();
        Player player = new Player();
        Player dealer = new Player();
        for (int i = 0; i < 2; i++) {
            Card c = deck.draw();
            Card d = deck.draw();
            player.addCard(c);
            dealer.addCard(d);
        }
        System.out.println(dealer.calculateHand());
        dealer.printFullHand();
    }
}
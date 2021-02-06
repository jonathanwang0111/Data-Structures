public class Player {
    private int numCards;
    private Card[] hand;
    public Player() {
        this.numCards = 0;
        this.hand = new Card[31];
    }

    public int calculateHand() {
        int sum = 0;
        for (int i = 0; i < this.numCards; i++) {
            if (this.hand[i].getVal() == 1) {
                
            }
            if (this.hand[i].getVal() > 10) {
                sum += 10;
            } else {
                sum += this.hand[i].getVal();
            }
        }
        return sum;
    }

    public void addCard(Card c) {
        this.hand[this.numCards] = c;
        this.numCards++;
    }

    public void printFullHand() {
        for (int i = 0; i < this.numCards; i++) {
            this.hand[i].print();
        }
    }
}
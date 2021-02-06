public class Card {
    private int val;
    private String suit;
    private Card next;
    private Card prev;
    public Card(int val, String suit) {
        this.val = val;
        this.suit = suit;
    }

    public void print() {
        System.out.println(this.val + " of " + this.suit);
    }

    public int getVal() {
        return this.val;
    }

    public String getSuit() {
        return this.suit;
    }

    public Card getNext() {
        return this.next;
    }

    public Card getPrev() {
        return this.prev;
    }

    public void setNext(Card c) {
        this.next = c;
        if (c != null) {
            c.setPrev(this);
        }
    }

    private void setPrev(Card c) {
        this.prev = c;
    }
}
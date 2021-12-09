package chap01;

/**
 * 관람객
 */
public class Audience {

    //소지품을 보유한 가방
    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    //티켓 구매 인터페이스(메시지)
    public Long buy(Ticket ticket) {
        return bag.hold(ticket);
    }

}

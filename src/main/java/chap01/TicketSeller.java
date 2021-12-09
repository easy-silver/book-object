package chap01;

/**
 * 매표소 판매원
 * (초대장을 티켓으로 교환해 주거나 티켓을 판매하는 역할 수행)
 */
public class TicketSeller {

    //판매원이 일하는 매표소
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public void sellTo(Audience audience) {
        //초대장 보유
        if (audience.getBag().hasInvitation()) {
            Ticket ticket = ticketOffice.getTicket();
            audience.getBag().setTicket(ticket);

        //티켓 구매
        } else {
            Ticket ticket = ticketOffice.getTicket();
            audience.getBag().minusAmount(ticket.getFee());
            ticketOffice.plusAmount(ticket.getFee());
            audience.getBag().setTicket(ticket);
        }
    }

}

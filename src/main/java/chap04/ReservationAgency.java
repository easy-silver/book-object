package chap04;

public class ReservationAgency {

    /**
     * 영화 예약
     *
     * @param screening
     * @param customer
     * @param audienceCount
     * @return
     */
    public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
        Money fee = screening.calculateFee(audienceCount);
        return new Reservation(customer, screening, fee, audienceCount);
    }

}

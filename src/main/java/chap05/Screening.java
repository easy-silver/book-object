package chap05;

import java.time.LocalDateTime;

/**
 * 상영
 * 책임: '예매하라' 메시지에 응답할 수 있어야 한다.
 */
public class Screening {

    //예매를 위해 필요한 인스턴스 변수
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    //예매를 처리하는 메서드
    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }

    //Movie에게 '가격을 계산하라'라는 메시지를 전송하는 메서드
    private Money calculateFee(int audienceCount) {

        //Screening과 Movie를 연결하는 유일한 연결 고리
        return movie.calculateMovieFee(this).times(audienceCount);
    }

}

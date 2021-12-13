package chap05;

import java.time.Duration;

/**
 * 할인 정책 미적용 영화
 */
public class NoneDiscountMovie extends Movie {

    public NoneDiscountMovie(String title, Duration runningTime, Money fee) {
        super(title, runningTime, fee);
    }

    @Override
    protected Money calculateDiscountAmount() {
        return Money.ZERO;
    }
}

package chap05;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

/**
 * 영화
 * 책임: '금액을 계산하라' 메시지에 응답할 수 있어야 한다.
 */
public abstract class Movie {

    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditions;

    public Movie(String title, Duration runningTime, Money fee, DiscountCondition... discountConditions) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountConditions = Arrays.asList(discountConditions);
    }

    //영화 예매 금액을 계산하는 메서드
    public Money calculateMovieFee(Screening screening) {
        if (isDiscountable(screening)) {
            return fee.minus(calculateDiscountAmount());
        }
        return fee;
    }

    //할인 조건을 순회하며 할인 조건에 해당하는지 확인하는 메서드
    private boolean isDiscountable(Screening screening) {
        return discountConditions.stream()
                .anyMatch(condition -> condition.isSatisfiedBy(screening));
    }

    //할인 정책의 종류에 따라 할인 금액을 계산하는 방식이 달라지므로 추상 메서드로 선언
    abstract protected Money calculateDiscountAmount();

    protected Money getFee() {
        return fee;
    }

}

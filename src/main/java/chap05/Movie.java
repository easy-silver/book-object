package chap05;

import chap04.MovieType;

import java.time.Duration;
import java.util.List;

/**
 * 영화
 * 책임: '금액을 계산하라' 메시지에 응답할 수 있어야 한다.
 */
public class Movie {

    private String title;
    private Duration runningTime;
    private Money fee;
    private List<PeriodCondition> periodConditions;
    private List<SequenceCondition> sequenceConditions;

    private MovieType movieType;
    private Money discountAmount;
    private double discountPercent;

    //영화 예매 금액을 계산하는 메서드
    public Money calculateMovieFee(Screening screening) {
        if (isDiscountable(screening)) {
            return fee.minus(calculateDiscountAmount());
        }
        return fee;
    }

    //할인 조건을 순회하며 할인 조건에 해당하는지 확인하는 메서드
    private boolean isDiscountable(Screening screening) {
        return checkPeriodConditions(screening) || checkSequenceConditions(screening);
    }

    private boolean checkPeriodConditions(Screening screening) {
        return periodConditions.stream()
                .anyMatch(condition -> condition.isSatisfiedBy(screening));
    }

    private boolean checkSequenceConditions(Screening screening) {
        return sequenceConditions.stream()
                .anyMatch(condition -> condition.isSatisfiedBy(screening));
    }

    //할인 정책을 확인하여 할인 금액 반환
    private Money calculateDiscountAmount() {
        switch (movieType) {
            case AMOUNT_DISCOUNT:
                return calculateAmountDiscountAmount();
            case PERCENT_DISCOUNT:
                return calculatePercentDiscountAmount();
            case NONE_DISCOUNT:
                return calculateNoneDiscountAmount();
        }

        throw new IllegalArgumentException();
    }

    //금액 할인의 할인 금액 계산
    private Money calculateAmountDiscountAmount() {
        return discountAmount;
    }

    //비율 할인의 할인 금액 계산
    private Money calculatePercentDiscountAmount() {
        return fee.times(discountPercent);
    }

    //할인 정책 미적용의 할인 금액 계산
    private Money calculateNoneDiscountAmount() {
        return Money.ZERO;
    }


}

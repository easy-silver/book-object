package chap11.phone.v2.additional;

import chap02.Money;
import chap11.phone.v2.RatePolicy;

/**
 * 기본 요금 할인 정책
 */
public class RateDiscountablePolicy extends AdditionalRatePolicy {

    private Money discountAmount;

    public RateDiscountablePolicy(RatePolicy next, Money discountAmount) {
        super(next);
        this.discountAmount = discountAmount;
    }

    //기본 요금 할인 계산
    @Override
    protected Money afterCalculated(Money fee) {
        return fee.minus(discountAmount);
    }
}

package chap11.phone.v1.nightly;

import chap02.Money;

import java.time.Duration;

/**
 * 심야 할인 요금제의 계산 결과에
 * 세금 정책을 적용한 후
 * 기본 요금 할인 정책을 적용
 */
public class TaxableAndRateNightlyDiscountablePhone extends TaxableNightlyDiscountPhone {
    private Money discountAmount;

    public TaxableAndRateNightlyDiscountablePhone(Money nightlyAmount, Money regularAmount, Duration seconds,
                                                  double taxRate, Money discountAmount) {
        super(nightlyAmount, regularAmount, seconds, taxRate);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money afterCalculated(Money fee) {
        return super.afterCalculated(fee).minus(discountAmount);
    }
}

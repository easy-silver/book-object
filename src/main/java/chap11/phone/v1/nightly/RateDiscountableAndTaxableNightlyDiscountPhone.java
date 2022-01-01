package chap11.phone.v1.nightly;

import chap02.Money;

import java.time.Duration;

/**
 * 심야 할인 요금제의 계산 결과에
 * 기본 요금 할인 정책을 적용한 후
 * 세금 정책을 적용
 */
public class RateDiscountableAndTaxableNightlyDiscountPhone extends RateDiscountableNightlyDiscountPhone {

    private double taxRate;

    public RateDiscountableAndTaxableNightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds,
                                                          Money discountAmount, double taxRate) {
        super(nightlyAmount, regularAmount, seconds, discountAmount);
        this.taxRate = taxRate;
    }

    @Override
    protected Money afterCalculated(Money fee) {
        return super.afterCalculated(fee).plus(fee.times(taxRate));
    }
}

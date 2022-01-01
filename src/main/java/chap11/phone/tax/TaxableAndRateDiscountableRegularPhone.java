package chap11.phone.tax;

import chap02.Money;

import java.time.Duration;

/**
 * 세금 계산 후
 * 기본 요금 할인 정책이 적용된 표준 요금제 클래스
 */
public class TaxableAndRateDiscountableRegularPhone extends TaxableRegularPhone {

    private Money discountAmount;

    public TaxableAndRateDiscountableRegularPhone(Money amount, Duration seconds, double taxRate, Money discountAmount) {
        super(amount, seconds, taxRate);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money afterCalculated(Money fee) {
        return super.afterCalculated(fee).minus(discountAmount);
    }
}

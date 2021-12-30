package chap11.phone;

import chap02.Money;

import java.time.Duration;

/**
 * 세금을 부과한 일반 요금제 계산
 */
public class TaxableRegularPhone extends RegularPhone {

    private double taxRate;

    public TaxableRegularPhone(Money amount, Duration seconds, double taxRate) {
        super(amount, seconds);
        this.taxRate = taxRate;
    }

    @Override
    protected Money calculateCallFee(Call call) {
        Money fee = super.calculateFee();
        return fee.plus(fee.times(taxRate));
    }
}

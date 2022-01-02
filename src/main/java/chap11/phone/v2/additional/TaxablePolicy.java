package chap11.phone.v2.additional;

import chap02.Money;
import chap11.phone.v2.RatePolicy;

/**
 * 세금 정책
 */
public class TaxablePolicy extends AdditionalRatePolicy {

    private double taxRatio;

    public TaxablePolicy(RatePolicy next, double taxRatio) {
        super(next);
        this.taxRatio = taxRatio;
    }

    //세금 정책에 해당하는 세금 계산
    @Override
    protected Money afterCalculated(Money fee) {
        return fee.plus(fee.times(taxRatio));
    }
}

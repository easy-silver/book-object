package chap11.phone.v2.additional;

import chap02.Money;
import chap11.phone.v2.Phone;
import chap11.phone.v2.RatePolicy;

/**
 * 부가 정책
 */
public abstract class AdditionalRatePolicy implements RatePolicy {
    private RatePolicy next;

    public AdditionalRatePolicy(RatePolicy next) {
        this.next = next;
    }

    @Override
    public Money calculateFee(Phone phone) {
        Money fee = next.calculateFee(phone);
        return afterCalculated(fee);
    }

    abstract protected Money afterCalculated(Money fee);
}

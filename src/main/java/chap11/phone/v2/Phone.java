package chap11.phone.v2;

import chap02.Money;

import java.util.ArrayList;
import java.util.List;

/**
 * 기본 정책을 이용해 요금을 계산하는 Phone
 */
public class Phone {

    private RatePolicy ratePolicy;
    private List<Call> calls = new ArrayList<>();

    public Phone(RatePolicy ratePolicy) {
        this.ratePolicy = ratePolicy;
    }

    public List<Call> getCalls() {
        return calls;
    }

    public Money calculateFee() {
        return ratePolicy.calculateFee(this);
    }

}

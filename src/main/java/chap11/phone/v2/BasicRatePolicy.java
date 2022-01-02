package chap11.phone.v2;

import chap02.Money;

/**
 * 기본 정책 요금 계산 추상 클래스
 * (일반 요금제, 심야 요금제)
 */
public abstract class BasicRatePolicy implements RatePolicy {

    @Override
    public Money calculateFee(Phone phone) {
        Money result = Money.ZERO;

        for (Call call : phone.getCalls()) {
            result.plus(calculateCallFee(call));
        }
        return result;
    }

    //개별 요금 계산은 요금제별로 위임한다.
    protected abstract Money calculateCallFee(Call call);
}

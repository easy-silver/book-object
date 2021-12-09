package chap02.discount.policy;

import chap02.Money;
import chap02.Screening;

/**
 * 할인 정책 미적용
 */
public class NoneDiscountPolicy implements DiscountPolicy {

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}

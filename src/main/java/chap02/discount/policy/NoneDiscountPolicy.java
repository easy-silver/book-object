package chap02.discount.policy;

import chap02.Money;
import chap02.Screening;

/**
 * 할인 정책 미적용
 */
public class NoneDiscountPolicy extends DiscountPolicy {

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}

package chap02.discount.condition;

import chap02.Screening;

/**
 * 할인 조건
 */
public interface DiscountCondition {

    boolean isSatisfiedBy(Screening screening);

}

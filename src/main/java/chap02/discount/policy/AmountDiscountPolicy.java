package chap02.discount.policy;

import chap02.Money;
import chap02.Screening;
import chap02.discount.condition.DiscountCondition;

/**
 * 금액 할인 정책
 */
public class AmountDiscountPolicy extends DiscountPolicy {

    //할인 요금
    private Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    /**
     * 할인 조건을 만족할 경우 <br>
     * 일정한 금액을 할인해주는 금액 할인 정책 구현
     *
     * @param screening
     * @return discountAmount
     */
    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
}

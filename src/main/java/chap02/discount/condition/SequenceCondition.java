package chap02.discount.condition;

import chap02.Screening;
import chap02.discount.condition.DiscountCondition;

/**
 * 할인 조건 - 순번 조건
 */
public class SequenceCondition implements DiscountCondition {

    private int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return screening.isSequence(sequence);
    }

}

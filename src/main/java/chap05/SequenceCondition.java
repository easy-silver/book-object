package chap05;

/**
 * 순번 할인 조건
 */
public class SequenceCondition implements DiscountCondition {

    private int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return sequence == screening.getSequence();
    }
}

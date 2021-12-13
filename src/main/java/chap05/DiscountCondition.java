package chap05;

/**
 * 할인 조건 인터페이스
 */
public interface DiscountCondition {

    //할인 조건 충족 여부 확인
    boolean isSatisfiedBy(Screening screening);
}

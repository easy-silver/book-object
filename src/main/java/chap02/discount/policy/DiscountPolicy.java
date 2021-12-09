package chap02.discount.policy;


import chap02.Money;
import chap02.Screening;

public interface DiscountPolicy {

    Money calculateDiscountAmount(Screening screening);

}

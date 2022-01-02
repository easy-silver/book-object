package chap11.phone.v2;

import chap02.Money;

/**
 * 기본 정책과 부가 정책을 포괄하는 인터페이스
 */
public interface RatePolicy {

    //계산된 요금 반환
    Money calculateFee(Phone phone);
}

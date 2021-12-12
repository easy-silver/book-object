package chap05;

import chap04.DiscountConditionType;

import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 * 할인 조건
 * 책임: '할인 적용 여부를 확인하라' 메시지에 응답할 수 있어야 한다.
 */
public class DiscountCondition {

    private DiscountConditionType type;
    private int sequence;
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    //조건 충족 여부를 확인하는 메서드
    public boolean isSatisfiedBy(Screening screening) {
        if (type == DiscountConditionType.PERIOD) {
            return isSatisfiedByPeriod(screening);
        }

        return isSatisfiedBySequence(screening);
    }

    //기간 조건 충족 여부 확인
    private boolean isSatisfiedByPeriod(Screening screening) {
        return dayOfWeek.equals(screening.getWhenScreened().getDayOfWeek()) &&
                startTime.compareTo(screening.getWhenScreened().toLocalTime()) <= 0 &&
                endTime.compareTo(screening.getWhenScreened().toLocalTime()) >= 0;
    }

    //순번 조건 충족 여부 확인
    private boolean isSatisfiedBySequence(Screening screening) {
        return sequence == screening.getSequence();
    }

}

package chap10;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * 개별 통화 기간을 저장하는 클래스
 */
public class Call {

    //통화 시작 시간
    private final LocalDateTime from;
    //통화 종료 시간
    private final LocalDateTime to;

    public Call(LocalDateTime from, LocalDateTime to) {
        this.from = from;
        this.to = to;
    }

    //통화 시간
    public Duration getDuration() {
        return Duration.between(from, to);
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public LocalDateTime getTo() {
        return to;
    }
}

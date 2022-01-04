package chap12.lecture;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class LectureTest {

    @Test
    void test() {
        //given
        Lecture lecture = new Lecture("객체지향 프로그래밍", 70, Arrays.asList(81, 95, 75, 50, 45));

        //when
        String evaluation = lecture.evaluate();

        //then
        System.out.println("evaluation = " + evaluation);
    }
}
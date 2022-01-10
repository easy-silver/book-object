package chap12.lecture;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class GradeLectureTest {

    @Test
    void test() {
        //given
        GradeLecture lecture = new GradeLecture("객체지향 프로그래밍",
                70,
                Arrays.asList(
                        new Grade("A", 100, 95),
                        new Grade("B", 94, 80),
                        new Grade("C", 79, 70),
                        new Grade("D", 69, 50),
                        new Grade("F", 49, 0)),
                Arrays.asList(81, 95, 75, 50, 45));

        //when
        String result = lecture.evaluate();

        //then
        System.out.println("result = " + result);
    }

}
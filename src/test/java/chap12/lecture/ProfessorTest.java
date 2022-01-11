package chap12.lecture;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class ProfessorTest {

    @Test
    void compileStatistics() {
        //given
        Professor professor = new Professor("다익스트라",
                new Lecture("알고리즘", 70, Arrays.asList(81, 95, 75, 50, 45)));

        //when
        String statistics = professor.compileStatistics();

        //then
        System.out.println("statistics = " + statistics);
    }
}
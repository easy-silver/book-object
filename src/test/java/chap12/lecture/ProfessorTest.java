package chap12.lecture;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class ProfessorTest {

    @Test
    void compileStatistics() {
        //given
        Professor professor = new Professor("다익스트라",
                new GradeLecture("알고리즘",
                        70,
                        Arrays.asList(new Grade("A", 100, 95),
                                new Grade("B", 94, 80),
                                new Grade("C", 79, 70),
                                new Grade("D", 69, 50),
                                new Grade("F", 49, 0)),
                        Arrays.asList(81, 95, 75, 50, 45)));

        //when
        String statistics = professor.compileStatistics();

        //then
        System.out.println("statistics = " + statistics);
    }
}
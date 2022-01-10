package chap12.lecture;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Lecture의 출력 결과에 등급별 통계를 추가한 클래스
 */
public class GradeLecture extends Lecture {

    private List<Grade> grades;

    public GradeLecture(String title, int pass, List<Grade> grades, List<Integer> scores) {
        super(title, pass, scores);
        this.grades = grades;
    }

    @Override
    public String evaluate() {
        return super.evaluate() + ", " + greadesStatistics();
    }

    private String greadesStatistics() {
        return grades.stream()
                .map(grade -> format(grade))
                .collect(Collectors.joining(" "));
    }

    private String format(Grade grade) {
        return String.format("%s:%d", grade.getName(), gradeCount(grade));
    }

    private long gradeCount(Grade grade) {
        return getScores().stream()
                .filter(grade::include)
                .count();
    }

    @Override
    public List<Integer> getScores() {
        return super.getScores();
    }

}

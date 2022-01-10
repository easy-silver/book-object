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
        return super.evaluate() + ", " + gradesStatistics();
    }

    private String gradesStatistics() {
        return grades.stream()
                .map(this::format)
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

    //등급별 평균 성적 계산
    public double average(String gradeName) {
        return grades.stream()
                .filter(each -> each.isName(gradeName))
                .findFirst()
                .map(this::gradeAverage)
                .orElse(0d);
    }

    //파라미터로 전달받은 등급의 평균 계산
    private double gradeAverage(Grade grade) {
        return getScores().stream()
                .filter(grade::include)
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
    }


}

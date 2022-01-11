package chap12.lecture;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 수강생들의 성적을 계산하는 클래스
 */
public class Lecture {

    //이수 여부를 판단할 기준 점수
    private int pass;
    //과목명
    private String title;
    //학생들의 성적 리스트
    private List<Integer> scores = new ArrayList<>();

    public Lecture(String title, int pass, List<Integer> scores) {
        this.title = title;
        this.pass = pass;
        this.scores = scores;
    }

    //전체 학생들의 평균 성적 계산
    public double average() {
        return scores.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
    }

    public List<Integer> getScores() {
        return Collections.unmodifiableList(scores);
    }

    public String evaluate() {
        return String.format("Pass:%d Fail:%d", passCount(), failCount());
    }

    private long passCount() {
        return scores.stream().filter(score -> score >= pass).count();
    }

    private long failCount() {
        return scores.size() - passCount();
    }

    public String stats() {
        return String.format("Title: %s, Evaluation Method: %s", title, getEvaluationMethod());
    }

    public String getEvaluationMethod() {
        return "Pass or Fail";
    }
}

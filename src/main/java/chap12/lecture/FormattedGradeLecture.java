package chap12.lecture;

import java.util.List;

public class FormattedGradeLecture extends GradeLecture {

    public FormattedGradeLecture(String title, int pass, List<Grade> grades, List<Integer> scores) {
        super(title, pass, grades, scores);
    }

    public String formatAverage() {
        //super 참조는 부모 클래스에 정의된 메서드를 실행하기 위한 것이 아니라
        //'지금 이 클래스의 부모 클래스에서부터 메서드 탐색을 시작하세요'의 의미이다.
        return String.format("Avg: %1.1f", super.average());
    }
}

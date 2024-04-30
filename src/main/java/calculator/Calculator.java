package calculator;

import java.util.LinkedList;

// 추상 클래스 & 부모 클래스
abstract class Calculator {
    // 연산 결과 & 원의 넓이를 저장하는 컬렉션 타입 필드가 생성자를 통해 초기화 되도록 변경
    private LinkedList<Double> list;

    abstract double calculate() throws Exception;

    // 생성자 구현
    Calculator() {
        this.list = new LinkedList<>();
    }

    // 리스트 간접 접근을 통해 외부로 내보내기
    public LinkedList<Double> getList() {
        return this.list;
    }

    // 리스트 간접 접근을 통해 외부(Calculator::calculate)에서 받아온 값 내부의 리스트 마지막에 값 추가
    public void setList(double result) {
        this.list.addLast(result);
    }

    // 리스트 간접 접근을 통해 내부의 리스트 값 전체 출력
    public void inquiryResults() {
        for (double savedResult : this.list) { // 리스트의 전체 값 출력
            System.out.println(savedResult);
        }
    }
}

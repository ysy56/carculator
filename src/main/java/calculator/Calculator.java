package calculator;

import java.util.LinkedList;

public class Calculator {
    /* final & static 활용 이유
    원주율은 변하지 않는 수(상수)이기 때문에
    자바에서 상수를 뜻하는 final static을 사용
    */
    final static double pi = 3.141592;

    // 연산 결과 & 원의 넓이를 저장하는 컬렉션 타입 필드가 생성자를 통해 초기화 되도록 변경
    private LinkedList<Integer> calculateList;
    private LinkedList<Double> circleAreaList;

    // 생성자 구현
    Calculator() {
        this.calculateList = new LinkedList<>();
        this.circleAreaList = new LinkedList<>();
    }

    public int calculate(int firstNumber, int secondNumber, char operator) throws Exception {
        int result = 0;
        /* switch를 이용하여 사칙연산 기호에 따른 계산 실행*/
        switch (operator) {
            case '+' -> result = firstNumber + secondNumber;
            case '-' -> result = firstNumber - secondNumber;
            case '*' -> result = firstNumber * secondNumber;
            case '/' -> {
                if (secondNumber == 0) // 분모에 0이 입력될 경우 예외문구 출력
                    throw new Exception("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                else
                    result = firstNumber / secondNumber;
            }
            default -> throw new Exception("+, -, *, /가 아닌 사칙연산은 입력할 수 없습니다.");
        }
        // 연산의 결과를 리스트에 저장
        setList(result);

        return result;
    }

    // 리스트 간접 접근을 통해 외부로 내보내기
    public LinkedList<Integer> getList() {
        return this.calculateList;
    }

    // 리스트 간접 접근을 통해 외부(Calculator::calculate)에서 받아온 값 내부의 리스트 마지막에 값 추가
    public void setList(int result) {
        this.calculateList.addLast(result);
    }

    // 리스트 간접 접근을 통해 내부의 리스트 첫 번째 값 삭제
    public void removeResult() {
        this.calculateList.removeFirst();
    }

    // 리스트 간접 접근을 통해 내부의 리스트 값 전체 출력
    public void inquiryResults() {
        for (int savedResult : this.calculateList) { // 리스트의 전체 값 출력
            System.out.println(savedResult);
        }
    }

    // 원의 넓이를 계산
    public double calculateCircleArea(int radius) {
        return radius * radius * pi;
    }

    // 원의 넓이를 저장한 리스트 간접 접근을 통해 외부로 내보내기
    public LinkedList<Double> getCircleAreaList() {
        return this.circleAreaList;
    }

    // 리스트 간접 접근을 통해 외부(App::main)에서 받아온 값 내부 원의 넓이를 저장한 리스트 마지막에 값 추가
    public void setCircleAreaList(double circleArea) {
        this.circleAreaList.addLast(circleArea);
    }

    // 리스트 간접 접근을 통해 내부의 리스트 값 전체 출력
    public void inquiryCircleArea() {
        for (double savedCircleArea : this.circleAreaList) { // 리스트의 전체 값 출력
            System.out.println(savedCircleArea);
        }
    }
}

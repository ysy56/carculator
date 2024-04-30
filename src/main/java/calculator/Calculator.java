package calculator;

import java.util.LinkedList;

public class Calculator {
    // 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성
    // 연산 결과를 저장하는 컬렉션 타입 필드를 외부에서 직접 접근 하지 못하도록 수정
    private LinkedList<Integer> list = new LinkedList<>();

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
        return this.list;
    }

    // 리스트 간접 접근을 통해 외부(Calculator::calculate)에서 받아온 값 내부의 리스트 마지막에 값 추가
    public void setList(int result) {
        this.list.addLast(result);
    }

    // 리스트 간접 접근을 통해 내부의 리스트 첫 번째 값 삭제
    public void removeResult() {
        this.list.removeFirst();
    }

    // 리스트 간접 접근을 통해 내부의 리스트 값 전체 출력
    public void inquiryResults() {
        for (int savedResult : this.list) { // 리스트의 전체 값 출력
            System.out.println(savedResult);
        }
    }
}

package calculator;

public class DivideOperator implements Operate{
    @Override
    public int operate(int firstNum, int secondNum) {
        if (secondNum == 0) // 분모에 0이 입력될 경우 예외문구 출력
            throw new ArithmeticException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
        return firstNum / secondNum;
    }
}

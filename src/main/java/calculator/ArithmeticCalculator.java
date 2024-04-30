package calculator;

import jdk.dynalink.Operation;

public class ArithmeticCalculator extends Calculator{
    private int firstNum;
    private int secondNum;
    private char operator;
    private Operate operate;

    private void setOperator(Operate operate) {
        this.operate = operate;
    }

    @Override
    double calculate() throws Exception {
        double result = 0;
        /* switch를 이용하여 사칙연산 기호에 따른 계산 실행*/
        switch (operator) {
            case '+' -> setOperator(new AddOperator());
            case '-' -> setOperator(new SubtractOperator());
            case '*' -> setOperator(new MultiplyOperator());
            case '/' -> {
                if (this.secondNum == 0) // 분모에 0이 입력될 경우 예외문구 출력
                    throw new Exception("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                else
                    setOperator(new DivideOperator());
            }
            case '%' -> setOperator(new ModOperator());
            default -> throw new Exception("+, -, *, /가 아닌 사칙연산은 입력할 수 없습니다.");
        }
        result = this.operate.operate(this.firstNum, this.secondNum);

        return result;
    }

    public void setNumAndOperator(int firstNum, int secondNum, char operator) {
        this.firstNum = firstNum;
        this.secondNum = secondNum;
        this.operator = operator;
    }

    // 리스트 간접 접근을 통해 내부의 리스트 첫 번째 값 삭제
    public void removeResult() {
        super.getList().removeFirst();
    }
}

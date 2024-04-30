package calculator;

public class ArithmeticCalculator extends Calculator {
    private double firstNum;
    private double secondNum;
    private char operator;

    @Override
    double calculate() throws Exception {
        double result = 0;
        /* switch를 이용하여 사칙연산 기호에 따른 계산 실행*/
        switch (operator) {
            case '+' -> result = this.firstNum + this.secondNum;
            case '-' -> result = this.firstNum - this.secondNum;
            case '*' -> result = this.firstNum * this.secondNum;
            case '/' -> {
                if (this.secondNum == 0) // 분모에 0이 입력될 경우 예외문구 출력
                    throw new Exception("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                else
                    result = this.firstNum / this.secondNum;
            }
            default -> throw new Exception("+, -, *, /가 아닌 사칙연산은 입력할 수 없습니다.");
        }

        return result;
    }

    public void setNumAndOperator(double firstNum, double secondNum, char operator) {
        this.firstNum = firstNum;
        this.secondNum = secondNum;
        this.operator = operator;
    }
}

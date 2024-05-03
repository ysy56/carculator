package calculator;

public class ArithmeticCalculator<T extends Number> extends Calculator{
    private T firstNum;
    private T secondNum;
    private Operate operate; // 연산을 수행할 객체
    OperatorType operatorType; // 연산자 타입

    public final Class<T> type;

    public ArithmeticCalculator(Class<T> type) {
        this.type = type;
    }

    // 연산을 설정하는 메서드
    private void setOperator(Operate operate) {
        this.operate = operate;
    }

    // 계산을 수행하는 메서드
    @Override
    public double calculate() {
        return (double) this.operate.operate(this.firstNum, this.secondNum); // 연산 수행 후 결과 반환
    }

    private void operatorFactory() {
        /* switch를 이용하여 사칙연산 기호에 따른 계산 실행*/
        switch (operatorType) {
            case PLUS -> setOperator(new AddOperator(type));
            case MINUS -> setOperator(new SubtractOperator(type));
            case MULTIPLY -> setOperator(new MultiplyOperator(type));
            case DIVIDE -> setOperator(new DivideOperator(type));
            case MOD -> setOperator(new ModOperator(type));
            default -> throw new IllegalArgumentException("해당하는 연산자가 없습니다.");
        }
    }

    // 숫자와 연산자를 설정하는 메서드
    public void setNumAndOperator(T firstNum, T secondNum, char operator) {
        this.firstNum = firstNum;
        this.secondNum = secondNum;
        this.operatorType = OperatorType.fromOperator(operator);
        operatorFactory(); // Initialize operate based on operatorType
    }

    // 리스트 간접 접근을 통해 내부의 리스트 첫 번째 값 삭제
    public void removeResult() {
        super.getList().removeFirst();
    }

    // 저장된 결과 중 입력값보다 큰 결과값들을 출력/조회하는 메서드
    public void printResultGreaterThan(double num) {
        super.getList().stream()
                .filter(result -> result.doubleValue() > num)
                .forEach(result -> System.out.println("연산 결과 : " + result));
    }
}

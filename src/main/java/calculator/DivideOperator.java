package calculator;

public class DivideOperator<T extends Number> implements Operate<T>{
    public final Class<T> type;

    public DivideOperator(Class<T> type) {
        this.type = type;
    }
    @Override
    public T operate(T firstNum, T secondNum) {
        if (secondNum.doubleValue() == 0) // 분모에 0이 입력될 경우 예외문구 출력
            throw new ArithmeticException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
        Number result = firstNum.doubleValue() / secondNum.doubleValue();

        return NumberConversionUtils.convertNumberToType(result, type);
    }
}

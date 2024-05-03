package calculator;

public class ModOperator<T extends Number> implements Operate<T> {
    public final Class<T> type;

    public ModOperator(Class<T> type) {
        this.type = type;
    }
    public T operate(T firstNum, T secondNum) {
        Number result = firstNum.doubleValue() % secondNum.doubleValue();

        return NumberConversionUtils.convertNumberToType(result, type);
    }
}

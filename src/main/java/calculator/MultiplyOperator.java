package calculator;

public class MultiplyOperator implements Operate{
    @Override
    public int operate (int firstNum, int secondNum) {
        return firstNum * secondNum;
    }
}

package calculator;

public class DivideOperator implements Operate{
    @Override
    public int operate(int firstNum, int secondNum) {
        return firstNum / secondNum;
    }
}

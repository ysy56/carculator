package calculator;

public class ModOperator implements Operate {
    @Override
    public int operate(int firstNum, int secondNum) {
        return firstNum % secondNum;
    }
}

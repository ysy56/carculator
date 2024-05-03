package calculator;

interface Operate <T extends Number>{
    T operate(T firstNum, T secondNum);
}

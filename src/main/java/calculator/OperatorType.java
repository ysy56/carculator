package calculator;

public enum OperatorType {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    MOD("%");

    // 각 연산자에 대응하는 기호
    private final String symbol;

    // 각 연산자의 기호를 초기화하는 생성자
    OperatorType(String symbol) {
        this.symbol = symbol;
    }

    // 연산자에 해당하는 기호를 반환하는 메서드
    public String getSymbol() {
        return symbol;
    }

    // 주어진 기호에 해당하는 OperatorType을 가져오는 메서드
    // 기호가 인식되지 않으면 IllegalArgumentException을 발생시킴
    public static OperatorType fromString(String symbol) throws IllegalArgumentException {
        // 모든 열거형 값을 반복
        for (OperatorType type : OperatorType.values()) {
            // 기호가 일치하는 경우 해당하는 OperatorType을 반환
            if (type.symbol.equals(symbol)) {
                return type;
            }
        }
        // 일치하는 것이 없는 경우 예외를 발생시킴
        throw new IllegalArgumentException("Unsupported operator: " + symbol);
    }
}

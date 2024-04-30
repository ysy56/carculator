package calculator;

public class CircleCalculator extends Calculator {
    /* final & static 활용 이유
   원주율은 변하지 않는 수(상수)이기 때문에
   자바에서 상수를 뜻하는 final static을 사용
   */
    final static double pi = 3.141592;

    private double radius;

    // 원의 넓이를 계산
    @Override
    public double calculate() {
        return this.radius * this.radius * pi;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}

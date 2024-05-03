package calculator;

import java.util.Objects;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        // Calculator 인스턴스 생성
        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator(Double.class);
        CircleCalculator circleCalculator = new CircleCalculator();

        Scanner sc = new Scanner(System.in);

        while (true) { // 반복문 사용 해서 연산을 반복
            // 사칙연산을 진행할지 원의 넓이를 구하지 선택 구현
            System.out.println("계산 방식을 선택해주세요. (원의 넓이 : circle, 계산 : calculate)");
            String answer = sc.nextLine();
            if (Objects.equals(answer, "circle")) {
                // 원의 반지름 입력받아 원의 넓이를 구한 후 출력
                System.out.print("원의 반지름을 입력하세요: ");
                int circleNum = sc.nextInt();
                sc.nextLine();

                circleCalculator.setRadius(circleNum);
                double circleArea = circleCalculator.calculate();
                System.out.println("결과 : " + circleArea);

                // 원의 넒이 저장
                circleCalculator.setList(circleArea);

                // 저장된 원의 넓이 값들 바로 전체 조회
                System.out.println("저장된 원의 넓이들");
                circleCalculator.inquiryResults();

            } else if (Objects.equals(answer, "calculate")) {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
                double firstNum = sc.nextDouble();
                sc.nextLine();

                System.out.print("두 번째 숫자를 입력하세요: ");
                // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
                double secondNum = sc.nextDouble();
                sc.nextLine();

                System.out.print("사칙연산 기호를 입력하세요: ");
                // 사칙연산 기호를 적합한 타입으로 선언한 변수에 저장합니다.
                char operator = sc.nextLine().charAt(0);

                // 연산을 수행 및 결과를 저장하는 Calculator::calculate
                double result = 0;
                arithmeticCalculator.setNumAndOperator(firstNum, secondNum, operator);
                try {
                    result = (double) arithmeticCalculator.calculate();
                } catch(Exception e) {
                    System.out.println(e.getMessage());
                }

                System.out.println("결과: " + result);

                // 연산의 결과를 리스트에 저장
                arithmeticCalculator.setList(result);

                // "remove" 입력 시 가장 먼저 저장된 결과 삭제
                System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
                String remove = sc.nextLine();
                if (Objects.equals(remove, "remove"))
                    arithmeticCalculator.removeResult(); // Calculator의 리스트 간접 접근을 통해 첫 번째 값 삭제

                // "inquiry" 입력 시 저장된 연산 결과 전부 출력
                System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                String inquiry = sc.nextLine();
                if (Objects.equals(inquiry, "inquiry"))
                    arithmeticCalculator.inquiryResults(); // Calculator의 리스트 간접 접근을 통해 리스트 값 전체 출력

                System.out.println("저장된 연산결과 중 입력한 값보다 큰 값들을 조회하시겠습니까? (lambda 입력시 조회)");
                if (Objects.equals(sc.nextLine(), "lambda")){
                    System.out.print("기준 값을 입력하세요 : ");
                    double num = sc.nextDouble();
                    sc.nextLine();
                    arithmeticCalculator.printResultGreaterThan(num);
                }
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                continue;
            }

            // exit을 입력 받으면 반복 종료
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String exit = sc.nextLine();
            if (Objects.equals(exit, "exit"))
                break;
        }
    }
}

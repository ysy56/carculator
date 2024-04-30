package calculator;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        // Calculator 인스턴스 생성
        Calculator cal = new Calculator();

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

                double circleArea = cal.calculateCircleArea(circleNum);
                System.out.println("결과 : " + circleArea);

                // 원의 넒이 저장
                cal.setCircleAreaList(circleArea);

                // 저장된 원의 넓이 값들 바로 전체 조회
                System.out.println("저장된 원의 넓이들");
                cal.inquiryCircleArea();

            } else if (Objects.equals(answer, "calculate")) {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
                int firstNum = sc.nextInt();
                sc.nextLine();

                System.out.print("두 번째 숫자를 입력하세요: ");
                // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
                int secondNum = sc.nextInt();
                sc.nextLine();

                System.out.print("사칙연산 기호를 입력하세요: ");
                // 사칙연산 기호를 적합한 타입으로 선언한 변수에 저장합니다.
                char operator = sc.nextLine().charAt(0);

                // 연산을 수행 및 결과를 저장하는 Calculator::calculate
                int result = 0;
                try {
                    result = cal.calculate(firstNum, secondNum, operator);
                } catch(Exception e) {
                    System.out.println(e.getMessage());
                }

                System.out.println("결과: " + result);

                // "remove" 입력 시 가장 먼저 저장된 결과 삭제
                System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
                String remove = sc.nextLine();
                if (Objects.equals(remove, "remove"))
                    cal.removeResult(); // Calculator의 리스트 간접 접근을 통해 첫 번째 값 삭제

                // "inquiry" 입력 시 저장된 연산 결과 전부 출력
                System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                String inquiry = sc.nextLine();
                if (Objects.equals(inquiry, "inquiry"))
                    cal.inquiryResults(); // Calculator의 리스트 간접 접근을 통해 리스트 값 전체 출력

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

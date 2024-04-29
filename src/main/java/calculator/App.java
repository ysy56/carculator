package calculator;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        // 연산의 결과를 저장할 리스트 생성
        LinkedList<Integer> list = new LinkedList<>();

        Scanner sc = new Scanner(System.in);

        while (true) { // 반복문 사용 해서 연산을 반복
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

            int result = 0;
            /* switch를 이용하여 사칙연산 기호에 따른 계산 실행*/
            switch (operator) {
                case '+':
                    result = firstNum + secondNum;
                    break;
                case '-':
                    result = firstNum - secondNum;
                    break;
                case '*':
                    result = firstNum * secondNum;
                    break;
                case '/':
                    if (secondNum == 0) // 분모에 0이 입력될 경우 예외문구 출력
                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    else
                        result = firstNum / secondNum;
                    break;
                default:
                    System.out.println("사칙연산 기호는 +, -, *, / 중에서 입력할 수 있습니다.");
            }
            System.out.println("결과: " + result);

            // 연산의 결과를 리스트에 저장
            list.addLast(result);

            // "remove" 입력 시 가장 먼저 저장된 결과 삭제
            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
            String remove = sc.nextLine();
            if (Objects.equals(remove, "remove"))
                list.removeFirst();

            // exit을 입력 받으면 반복 종료
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String exit = sc.nextLine();
            if (Objects.equals(exit, "exit"))
                break;
        }
    }
}

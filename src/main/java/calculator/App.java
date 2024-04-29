package calculator;

import java.util.Objects;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        // 연산의 결과를 저장할 배열 생성
        int[] resultArray = new int[10];
        // 연산의 결과가 저장된 배열의 마지막 index를 저장하는 변수 선언
        int resultArrayIndex = 0;

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

            // 연산 결과가 10개를 초과할 경우 가장 먼저 저장된 결과 삭제 후 새로운 연산 결과 저장
            // Hint : 결과 값을 한 칸 씩 앞으로 이동
            if (resultArrayIndex >= 10) {
                for (int i = 0; i < resultArrayIndex - 1; i++) {
                    resultArray[i] = resultArray[i + 1];
                }
                System.out.print(resultArrayIndex+" ");
                resultArrayIndex--;
            }

            // 연산 결과 배열에 저장 후 index 증가
            resultArray[resultArrayIndex++] = result;

            // exit을 입력 받으면 반복 종료
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String answer = sc.nextLine();
            if (Objects.equals(answer, "exit"))
                break;
        }
    }
}

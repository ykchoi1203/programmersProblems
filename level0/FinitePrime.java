package programmersProblum.level0;

public class FinitePrime {

    public static void main(String[] args) {
        System.out.println(solution(2 * 3 * 5 * 7 * 11, 2 * 2 * 3 * 5 * 7 * 11));
    }

    public static int solution(int a, int b) {
        // 1, 2, 5 면 바로 return 1, 두 수가 같아도 바로 return 1
        if (b == 1 || b == 2 || b == 5 || a == b)
            return 1;
        // 2랑 5랑 나눠질 때까지 나누기
        while (true) {
            if (b % 2 == 0)
                b /= 2;
            else if (b % 5 == 0)
                b /= 5;
            else
                break;
        }
        // i=3부터 a와 b가 i로 나누어 떨어지면 나누어 주고 다시 그 숫자로 나누어 지는지
        // 홀수만 판단하면 되기 때문에 i += 2씩 늘려줌
        for (int i = 3; i <= b;) {
            if (a == b)
                return 1;
            else if (a % i == 0 && b % i == 0) {
                a /= i;
                b /= i;
                continue;
            }
            i += 2;
        }
        if (b == 1)
            return 1;
        return 2;
    }
}

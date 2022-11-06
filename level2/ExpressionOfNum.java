package programmersProblum.level2;

public class ExpressionOfNum {
    public static void main(String[] args) {
        System.out.println(solution(15));
        System.out.println(solution(2));
        System.out.println(solution(3));
    }

    public static int solution(int n) {
        int answer = 1;
        if(n == 1)
            return 1;
        if(n == 2)
            return 1;

        for(int i = n/2 + 1; i>0; i--){
            int sum = i;
            int j = i;
            while(sum < n && j > 1){
                sum += --j;
            }
            if(sum == n)
                answer++;
            if(j <= 1)
                break;
        }

        return answer;
    }
}

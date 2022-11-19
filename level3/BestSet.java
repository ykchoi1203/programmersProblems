package programmersProblum.level3;

import java.util.Arrays;

public class BestSet {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, 10)));
        System.out.println(Arrays.toString(solution(2, 9)));
        System.out.println(Arrays.toString(solution(5, 45)));
    }
    public static int[] solution(int n, int s) {
        if(n > s) return new int[] {-1};
        int[] answer = new int[n];
        int k = s / n;

        Arrays.fill(answer, k);

        for(int i=answer.length-1; k * n < s; s--, i--)
            answer[i]++;

        return answer;
    }
}

package programmersProblum.level1;

import java.util.Arrays;

public class Fruiterer {
    public static void main(String[] args) {
        System.out.println(solution(3, 4, new int[]{1, 2, 3, 1, 2, 3, 1}));
        System.out.println(solution(4, 3, new int[]{4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2}));
    }

    public static int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);

        for(int i=score.length-1; i >= m - 1; i-=m){
            answer += score[i - m + 1] * m;
        }
        return answer;
    }

}

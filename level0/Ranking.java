package programmersProblum.level0;

import java.util.Arrays;

public class Ranking {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[][] {{80, 70}, {70, 80}, {30, 50}, {90, 100}, {100, 90}, {100, 100}, {10, 30}})));
        System.out.println(Arrays.toString(solution(new int[][] {{1, 2}, {1, 1}, {1, 1}})));
    }

    public static int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        int[] avg = new int[score.length];
        for(int i=0; i<score.length; i++) {
            avg[i] = score[i][0] + score[i][1];
        }
        double max;
        int rate = 1;
        for(int i=0; i<answer.length;) {
            max = Arrays.stream(avg).max().getAsInt();
            int cnt = 0;
            for(int j=0; j<avg.length; j++) {
                if(max == avg[j]){
                    answer[j] = rate;
                    avg[j] = -1;
                    cnt++;
                }
            }
            rate += cnt;
            i += cnt;
        }

        return answer;
    }
}

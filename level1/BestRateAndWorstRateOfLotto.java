package programmersProblum.level1;

import java.util.Arrays;

public class BestRateAndWorstRateOfLotto {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {2,3,4,5,7,8}, new int[] {31,10,45,1,6,19})));
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int cnt = 0;
        int zeroCount = (int)Arrays.stream(lottos).filter(e -> e==0).count();

        Arrays.sort(lottos);
        Arrays.sort(win_nums);

        for(int i = win_nums.length -1; i >= 0; i--) {
            for(int j = lottos.length -1; j >= 0; j--) {
                if(win_nums[i] == lottos[j]) {
                    cnt++;
                    break;
                } else if(win_nums[i] > lottos[j]) break;
            }
        }

        return new int[] {7 - cnt - zeroCount >= 6 ? 6 : 7 - cnt - zeroCount , 7 - cnt >= 6 ? 6 : 7 - cnt};
    }
}

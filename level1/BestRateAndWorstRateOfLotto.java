package programmersProblum.level1;

import java.util.Arrays;

public class BestRateAndWorstRateOfLotto {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {2,3,4,5,7,8}, new int[] {31,10,45,1,6,19})));
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int cnt = 0;
        // 0의 개수를 받는다.
        int zeroCount = (int)Arrays.stream(lottos).filter(e -> e==0).count();

        Arrays.sort(lottos);
        Arrays.sort(win_nums);

        // 정렬후 뒤에서부터 번호 체크 -> 로또에는 0이 들어가있기 때문
        for(int i = win_nums.length -1; i >= 0; i--) {
            // 0이 들어있는 배열은 검사 안해도되기 때문에 j>= zeroCount
            for(int j = lottos.length -1; j >= zeroCount; j--) {
                // 숫자가 맞으면 cnt++
                if(win_nums[i] == lottos[j]) {
                    cnt++;
                    break;
                }
                // 해당 숫자가 넘어가면 뒤에건 검사할 필요가 없기 때문에 break 해줌 -> 정렬을 했기 때문에
                else if(win_nums[i] > lottos[j]) break;
            }
        }
        // 최소는 7(등)에서 cnt 값을 뺀것인데 해당 값이 6 이상이면 6등이기 때문에 6, 아니면 7 - cnt (6개 다 맞추면 1등)
        // 최대는 zeroCount 까지 빼준 값
        return new int[] {7 - cnt - zeroCount >= 6 ? 6 : 7 - cnt - zeroCount , 7 - cnt >= 6 ? 6 : 7 - cnt};
    }
}

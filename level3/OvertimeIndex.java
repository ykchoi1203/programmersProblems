package programmersProblum.level3;

import java.util.Arrays;

public class OvertimeIndex {

    public static void main(String[] args) {
        System.out.println(solution(4, new int[]{4, 3, 3}));
    }

    public static long solution(int n, int[] works) {
        long answer = 0;
        long work = Arrays.stream(works).mapToLong(num -> num).sum();
        if (work - n <= 0) return 0;
        Arrays.sort(works);

        while (n > 0) {
            int max = works[works.length - 1];
            for (int i = works.length - 1; i >= 0; i--) {
                if (works[i] != max || n == 0)
                    break;
                else {
                    works[i] = works[i] - 1;
                    n--;
                }
            }
        }
//        for(int num : works) {
//            answer += Math.pow(num, 2);
//        }
        return Arrays.stream(works).mapToLong(num -> num*num).sum();
//        return answer;
    }
}

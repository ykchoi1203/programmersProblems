package programmersProblum.level3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NetworkProblem {

    public static void main(String[] args) {
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] arr = new boolean[computers.length];

        Arrays.fill(arr, false);

        Queue<Integer> queue = new LinkedList<>();


        for (int i = 0; i < arr.length; i++) {
            if (!arr[i]) {
                arr[i] = true;
                queue.add(i);
                while (!queue.isEmpty()) {
                    int idx = queue.poll();
                    for (int j = 0; j < n; j++) {
                        if (computers[idx][j] == 1) {
                            if (!arr[j]) {
                                queue.add(j);
                                arr[j] = true;
                            }
                        }
                    }
                }
                answer++;
            }
        }

        return answer;
    }
}

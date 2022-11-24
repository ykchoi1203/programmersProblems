package programmersProblum.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class GymSuit {
    public static void main(String[] args) {
        System.out.println(solution(5, new int[] {4,2}, new int[] {3,5}));
        System.out.println(solution(5, new int[] {2,4}, new int[] {1,3,5}));
        System.out.println(solution(3, new int[] {3}, new int[] {1}));
        System.out.println(solution(13, new int[] {1,2,5,6,10,12,13}, new int[] {2,3,4,5,7,8,9,10,11,12}));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        ArrayList<Integer> reserveAl = new ArrayList<>(Arrays.stream(reserve).boxed().sorted().collect(Collectors.toList()));
        ArrayList<Integer> lostAl = new ArrayList<>(Arrays.stream(lost).boxed().sorted().collect(Collectors.toList()));
        // 제한 사항을 잘 읽자.
        // 여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다.
        // 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.
        for(int i=0; i<lostAl.size(); i++) {
            if(!reserveAl.isEmpty()) {
                if (reserveAl.contains(lostAl.get(i))) {
                    reserveAl.remove(reserveAl.indexOf(lostAl.get(i)));
                    lostAl.remove(i);
                    i--;
                }
            }
        }

        for(int i=0; i<lostAl.size();i++) {
            if(!reserveAl.isEmpty()) {
                if (reserveAl.contains(lostAl.get(i) - 1)) {
                    reserveAl.remove(reserveAl.indexOf(lostAl.get(i) - 1));
                    lostAl.remove(i);
                    i--;
                } else if (reserveAl.contains(lostAl.get(i) + 1)) {
                    reserveAl.remove(reserveAl.indexOf(lostAl.get(i) + 1));
                    lostAl.remove(i);
                    i--;
                }
            } else break;
        }

        return answer - lostAl.size();
    }
}

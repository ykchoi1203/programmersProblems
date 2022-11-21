package programmersProblum.level1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class FailureRate {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{2,1,2,4,2,4,3,3})));
    }

    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        TreeMap<Integer, Double> treeMap = new TreeMap<>();
        // 1 ~ N+1 까지의 문제들의 count를 treeMap에 넣어줌
        for(int i=1; i<=N+1; i++) {
            int k = i;
            double cnt = (double)Arrays.stream(stages).filter(num -> num == k).count();
            treeMap.put(i, cnt);
        }
        // 높은곳부터 낮은곳까지 cnt값을 더해줌 (해당 문제까지 도달한 사람 수를 구하기 위하여)
        // 해당 key = i 인 treeMap에
        // treeMap.get(i) (클리어 하지 못한 수) / cnt((해당 문제까지 도달한 사람 수)
        // 를 해서 덮어씌움 -> 실패율 넣기
        int cnt = (int)Math.round(treeMap.get(N+1));
        for(int i=N; i>0; i--) {
            int num = (int)Math.round((treeMap.get(i)));
            if(num == 0)
                treeMap.put(i, 0.0);
            else {
                cnt += num;
                treeMap.put(i, treeMap.get(i) / cnt);
            }
        }

        // N+1 에 도달한 사람의 실패율은 필요없으니 제거.
        if(treeMap.containsKey(N+1))
            treeMap.remove(N+1);

        answer = treeMap.entrySet().stream()    // entrySet 으로 스트림
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue())) // comparingByValue() value 값으로 역순 정렬
                .mapToInt(el -> el.getKey()).toArray();
        
//        // answer에 넣을 위치를 알려줄 cursor 변수 생성
//        int cursor = 0;
//        // treeMap의 사이즈가 0이 아닐때까지 진행 -> 실패율이 제일 큰것을 제거할 것이기 때문
//        while(treeMap.size() != 0) {
//            int i=1;            // 높은 key 값을 저장할 변수 (나중에 제거 및 answer에 추가를 위해)
//            double max = -1;    // 실패율은 0보다 작을 수 없기 때문에 초기값으로 -1을 줌
//            // key값을 받아 max보다 treeMap(key)가 크다면
//            // max값을 treeMap.get(key) -> value(실패율)값로 바꾸고, i를 key값으로 바꿈
//            for(int key : treeMap.keySet()){
//                if(treeMap.get(key) > max) {
//                    max = treeMap.get(key);
//                    i = key;
//                }
//            }
//            // 해당 키 값를 answer의 커서위치에 넣어줌
//            answer[cursor] = i;
//            // 저장했으니 해당 키값 제거
//            treeMap.remove(i);
//            // 커서 위치 +1
//            cursor++;
//        }

        return answer;
    }
}

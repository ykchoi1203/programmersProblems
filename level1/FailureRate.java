package programmersProblum.level1;

import java.util.Arrays;
import java.util.TreeMap;

public class FailureRate {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{2,1,2,4,2,4,3,3})));
    }

    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        TreeMap<Integer, Double> treeMap = new TreeMap<>();

        for(int i=0; i<stages.length; i++) {
            if(treeMap.containsKey(stages[i])) {
                treeMap.put(stages[i], treeMap.get(stages[i]) + 1);
            } else {
                treeMap.put(stages[i], 1.0);
            }
        }
        int cnt = treeMap.containsKey(N+1) ? (int)Math.round((treeMap.get(N+1))) : 0;
        for(int i=N; i>0; i--) {
            if(treeMap.containsKey(i)){
                cnt += (int)Math.round((treeMap.get(i)));
                treeMap.put(i, treeMap.get(i) / cnt);
            } else {
                treeMap.put(i, 0.0);
            }
        }
        if(treeMap.containsKey(N+1))
            treeMap.remove(N+1);

        int cursor = 0;
        while(treeMap.size() != 0) {
            int i=1;
            double max = -1;
            for(int j=1; j<=N; j++) {
                if(treeMap.containsKey(j)){
                    if(max < treeMap.get(j)) {
                        i = j;
                        max = treeMap.get(i);
                    }
                }
            }
            answer[cursor] = i;
            treeMap.remove(i);
            cursor++;
        }

        return answer;
    }
}

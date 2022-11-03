package programmersProblum.level1;

public class NumberFriend {
    public static void main(String[] args) {
        System.out.println(solution("113890", "11345670"));
    }

    public static String solution(String X, String Y) {
        // String + 연산 사용시 11~15 테스트 케이스에서 시간 초과
        // String + 연산은 메모리 할당과 메모리 해제를 발생시키며 성능적으로 떨어지게됨
        // StringBuilder는 기존의 데이터에 더하는 방식을 사용하기 때문에 속도도 빠르고 상대적으로 부하가 적다.
        StringBuilder sb = new StringBuilder();

        int[] xMap = new int[10];
        int[] yMap = new int[10];

        for(int i=0; i<X.length(); i++){
            xMap[X.charAt(i) - '0'] += 1;
        }
        for(int i=0; i<Y.length(); i++){
            yMap[Y.charAt(i) - '0'] += 1;
        }
        int cnt = 0;

        for(int i=xMap.length-1; i>=0; i--){
            int j = (xMap[i] > yMap[i]) ? yMap[i] : xMap[i];
            if(cnt == 0 && i == 0 && j != 0)
                return "0";
            for(int k=0; k<j; k++){
                sb.append(i);
                cnt++;
            }
        }

        if(cnt == 0){
            return "-1";
        }

        return sb.toString();



        /*HashMap<Integer, Integer> xMap = new HashMap<>();
        HashMap<Integer, Integer> yMap = new HashMap<>();

        for (int i = 0; i < X.length(); i++) {
            if (xMap.containsKey(X.charAt(i) - '0')) {
                xMap.replace(X.charAt(i) - '0', xMap.get(X.charAt(i) - '0') + 1);
            } else {
                xMap.put(X.charAt(i) - '0', 1);
            }
        }
        for (int i = 0; i < Y.length(); i++) {
            if (yMap.containsKey(Y.charAt(i) - '0')) {
                yMap.replace(Y.charAt(i) - '0', yMap.get(Y.charAt(i) - '0') + 1);
            } else {
                yMap.put(Y.charAt(i) - '0', 1);
            }
        }

        List<Integer> xList = new ArrayList<>(xMap.keySet());
        List<Integer> yList = new ArrayList<>(yMap.keySet());

        Collections.reverse(xList);
        Collections.reverse(yList);
        int cnt = 0;
        for(int key : xList){
            if(yList.contains(key)){
                if(cnt == 0 && key == 0){
                    answer = "0";
                    cnt++;
                    break;
                }
                int num = (xMap.get(key) > yMap.get(key)) ? yMap.get(key) : xMap.get(key);
                for(int i=0; i<num; i++){
                    answer += key;
                    cnt++;
                }
            }
        }
        if(cnt == 0)
            return "-1";


        return answer;*/
    }
}

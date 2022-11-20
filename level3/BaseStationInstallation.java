package programmersProblum.level3;

public class BaseStationInstallation {

    public static void main(String[] args) {
        System.out.println(solution(11, new int[]{4, 11}, 1));
        System.out.println(solution(16, new int[]{9}, 2));
        System.out.println(solution(14, new int[] {0}, 2));
    }

    public static int solution(int n, int[] stations, int w) {
        int answer = 0;
        boolean isFalse = stations[0] -1 - w <= 0 ? false : true;
        int cursor = 0;
        for(int i=0; i<n;) {
            if(cursor < stations.length && stations[cursor] -w -1 <= i ) {
                i = stations[cursor] + w;
                cursor++;
                if (isFalse == true) {
                    answer++;
                    isFalse = false;
                }
                continue;
            }
            if(isFalse) {
                if(i == 0) {
                    i += w;
                    isFalse = true;
                    continue;
                }
                answer++;
                i += w + 1;
                isFalse = false;
            } else {
                isFalse = true;
                i += w;
                if(i >=n) {
                    answer++;
                }
            }

        }

        return answer;
    }
}

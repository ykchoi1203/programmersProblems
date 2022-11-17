package programmersProblum.level0;

public class ConditionOfTriangle {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{11, 7}));
    }
    public static int solution(int[] sides) {
        int answer = 0;

        int max = sides[0] > sides[1] ? sides[0] : sides[1];
        int min = sides[0] > sides[1] ? sides[1] : sides[0];

        for(int i= 1; i < max; i++) {
            if(max < min + i) {
                answer ++;
            }
        }

        for(int i= max; i < max + min; i++) {
            if(max + min > i) {
                answer ++;
            }
        }

        return answer;
    }
}

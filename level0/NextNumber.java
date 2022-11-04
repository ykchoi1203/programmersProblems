package programmersProblum.level0;

public class NextNumber {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4}));
        System.out.println(solution(new int[]{2,4,8}));
    }
    public static int solution(int[] common) {
        int answer = 0;

        int[] difference = new int[2];
        difference[0] = common[1] - common[0];
        difference[1] = common[2] - common[1];

        if(difference[0] == difference[1])
            answer = common[0] + difference[0] * common.length;
        else{
            answer = common[0] * (int) Math.pow((int)difference[1]/difference[0], common.length);
        }


        return answer;
    }

}



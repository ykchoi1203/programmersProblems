package programmersProblum.level1;

public class Trio {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{-1, -3, 5, -4, 0, 4, 6}));
    }
    public static int solution(int[] number) {
        int answer = 0;

        for(int i=0; i<number.length-2; i++){
            for(int j=i+1; j<number.length-1; j++){
                for(int k=j+1; k<number.length; k++){
                    if(number[i] + number[j] + number[k] == 0){
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}

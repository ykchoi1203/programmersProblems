package programmersProblum.level1;

import java.util.Stack;

public class DartGame {

    public static void main(String[] args) {
        System.out.println(solution("1D2S#10S"));
    }

    public static int solution(String dartResult) {
        int answer;

        Stack<Integer> score = new Stack<>();

        for(int i=0; i<dartResult.length(); i++) {
            char s = dartResult.charAt(i);
            if(s == '*') {
                Stack<Integer> copy = new Stack<>();
                for(int j=0; j<2; j++) {
                    if (!score.isEmpty()) {
                        copy.push(score.pop() * 2);
                    }
                }
                while(!copy.isEmpty()){
                    score.push(copy.pop());
                }
            } else if (s == '#') {
                if(!score.isEmpty()) {
                    score.push(score.pop() * -1);
                }
            } else if (s == 'D') {
                if(!score.isEmpty()) {
                    score.push((int)Math.pow(score.pop(), 2));
                }
            } else if (s == 'T') {
                if(!score.isEmpty()) {
                    score.push((int)Math.pow(score.pop(), 3));
                }
            } else if (s >= '0' && s <= '9') {
                if(i != 0 && dartResult.charAt(i-1) == '1' && s == '0') {
                    score.push(score.pop() + 9);
                }
                else score.push(s - '0');
            }
        }

        answer = score.stream().mapToInt(m -> m).sum();

        return answer;
    }
}

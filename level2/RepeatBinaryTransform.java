package programmersProblum.level2;

import java.util.Arrays;

public class RepeatBinaryTransform {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("110010101001")));
        System.out.println(Arrays.toString(solution("01110")));
        System.out.println(Arrays.toString(solution("1111111")));
    }

    public static int[] solution(String s) {
        int[] answer = new int[2];

        while(!s.equals("1")){
            int sLen = s.length();
            s = s.replace("0", "");
            answer[0]++;
            answer[1] += sLen - s.length();
            s = binaryScale(s.length());
            // Integer.toBinaryString() 이라는 좋은 메서드가 있다.... 첨 알았다...
        }

        return answer;
    }

    public static String binaryScale(int i){
        StringBuilder sb = new StringBuilder();
        while(i > 1){
            sb.append(i%2);
            i /= 2;
        }
        sb.append(1);

        return sb.reverse().toString();

    }
}

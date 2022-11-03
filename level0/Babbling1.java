package programmersProblum.level0;

public class Babbling1 {
    public static void main(String[] args) {
        String[] babbling = {"aya", "yee", "u", "maa", "wyeoo"};
        System.out.println(solution(babbling));
    }

    public static int solution(String[] babbling) {
        int answer = 0;

        /* 정규식... 고수님의 코드 단... 4줄... 정규식을 공부해보자...
            for(String s : babbling){
                if(s.matches("^(aya(?!aya)|ye(?!ye)|woo(?!woo)|ma(?!ma))+$")){
                    answer++;
                }
            }
         */

        for (int i = 0; i < babbling.length; i++) {
            int bbLength = babbling[i].length();
            String s = babbling[i];

            if (bbLength > 10 || bbLength == 1)
                continue;
            while (true) {
                if(s.length() == 0)
                    break;
                else if (s.charAt(0) == 'a' && s.length() > 2) {
                    if (s.charAt(1) == 'y' && s.charAt(2) == 'a')
                        s = s.substring(3);
                    else break;
                } else if (s.charAt(0) == 'w' && s.length() > 2) {
                    if (s.charAt(1) == 'o' && s.charAt(2) == 'o')
                        s = s.substring(3);
                    else break;
                } else if (s.charAt(0) == 'y' && s.length() > 1) {
                    if (s.charAt(1) == 'e')
                        s = s.substring(2);
                    else break;
                } else if (s.charAt(0) == 'm' && s.length() > 1) {
                    if (s.charAt(1) == 'a')
                        s = s.substring(2);
                    else break;
                } else
                    break;
            }
            if (s.equals(""))
                answer++;
        }

        return answer;
    }
}

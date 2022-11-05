package programmersProblum.level2;

import java.util.LinkedList;
import java.util.Queue;

public class RightBracket {

    public static void main(String[] args) {
        String[] arr = {"()()", "(())()", ")()(", "(()("};
        for(String s : arr){
            System.out.println(solution(s));
        }

    }

    static boolean solution(String s) {
        boolean answer = true;
        Queue<Character> qStr = new LinkedList<>();
        // 효율성 테스트 2번 통과
        if(s.length() % 2 != 0)
            return false;
        else if(s.length()/2 < s.replace(")", "").length()
                || s.length()/2 > s.replace(")", "").length())
            return false;

        for(int i=0; i<s.length(); i++){
            if(qStr.size() == 0){
                if(s.charAt(i) == ')'){
                    return false;
                } else{
                    qStr.add(s.charAt(i));
                }
            } else {
                if(s.charAt(i) == '('){
                    qStr.add(s.charAt(i));
                } else{
                    qStr.poll();
                }
            }
        }
        return qStr.size()==0 ? true : false;
    }
}

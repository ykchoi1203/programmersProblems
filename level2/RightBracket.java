package programmersProblum.level2;

public class RightBracket {

    public static void main(String[] args) {
        String[] arr = {"()()", "(())()", ")()(", "(()("};
        for (String s : arr) {
            System.out.println(solution(s));
        }

    }

//  효율성 1 2 번 모두 통과!
    static boolean solution(String s) {
        boolean answer = true;

        if (s.length() % 2 != 0)
            return false;
        else if (s.length() / 2 < s.replace(")", "").length()
                || s.length() / 2 > s.replace(")", "").length())
            return false;
        else if (s.charAt(0) != '(' || s.charAt(s.length() - 1) != ')')
            return false;

        int cnt = 0;
        int cnt1 = 0;
        // ( 가 들어오면 +1, ) 가 들어오면 -1
        // 앞에서부터 한거는 ( 보다 ) 가 많으면 안되므로 cnt 음수가 나오면 false
        // 반대로 뒤에서부터 한거는 ) 보다 ( 가 많으면 안되므로 cnt1이 양수가 나오면 false
        // for 문을 반으로 줄이는게 핵심! 근데 반으로 안줄여도 되던데..? 왜 내가 했을 땐 통과가 안되었을까...?
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) == '(')
                cnt++;
            else
                cnt--;
            if (cnt < 0)
                return false;
            if (s.charAt(s.length() - 1 - i) == '(')
                cnt1++;
            else
                cnt1--;
            if (cnt1 > 0)
                return false;
        }
        return cnt + cnt1 == 0 ? true : false;
    }
}


// 처음 생각한 방법
//    static boolean solution(String s) {
//        boolean answer = true;
//        Queue<Character> qStr = new LinkedList<>();
//        // 효율성 테스트 2번 통과
//        if(s.length() % 2 != 0) // 길이가 홀수면 false
//            return false;
//        else if(s.length()/2 < s.replace(")", "").length()
//                || s.length()/2 > s.replace(")", "").length()) // '(' 개수와 ')' 개수가 다르면 false
//            return false;
//
//        for(int i=0; i<s.length(); i++){
//            if(qStr.size() == 0){ // 큐 사이즈가 0 이면서 ')' 이 들어오면 false
//                if(s.charAt(i) == ')'){
//                    return false;
//                } else{   // 아니면 추가
//                    qStr.add(s.charAt(i));
//                }
//            } else {
//                if(s.charAt(i) == '('){
//                    qStr.add(s.charAt(i));
//                } else{
//                    qStr.poll();
//                }
//            }
//        }
//        return qStr.size()==0 ? true : false;
//    }
// }

// 더 간단해진 코드. 하지만 효율성 1번은 아직도 시간 초과
//    boolean solution(String s) {
//        if (s.length() % 2 != 0)
//            return false;
//        else if (s.length() / 2 < s.replace(")", "").length()
//                || s.length() / 2 > s.replace(")", "").length())
//            return false;
//        else if (s.charAt(0) != '(' || s.charAt(s.length() - 1) != ')')
//            return false;
//
//        int cnt = 0;
//
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '(')
//                cnt++;
//            else
//                cnt--;
//            if (cnt < 0)
//                return false;
//            if (cnt > s.length() - i)
//                return false;
//        }
//        return true;
//    }
//}
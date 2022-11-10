package programmersProblum.level0;

import java.util.LinkedList;

public class ControlZ {
    public static void main(String[] args) {
        System.out.println(solution("1 2 Z 3 4 Z Z "));
    }

    public static int solution(String s) {
        int answer = 0;
        if(s.length() == 0)
            return 0;
        String[] strArr = s.split(" ");

        // LinkedList로 풀기. ArrayList도 똑같을듯
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=0; i < strArr.length; i++){
            if(strArr[i].equals("Z")){
                if(!list.isEmpty())
                    list.remove(list.size() - 1);
            }
            else
                list.add(Integer.parseInt(strArr[i]));
        }
        for(int i : list) {
            answer += i;
        }
//        // 스텍으로 풀기
//        Stack<Integer> stack = new Stack<>();
//
//        for (int i = 0; i < strArr.length; i++) {
//            if (strArr[i].equals("Z")) {
//                if (!stack.isEmpty())
//                    stack.pop();
//            } else
//                stack.push(Integer.parseInt(strArr[i]));
//        }
//        while (!stack.isEmpty()) {
//            answer += stack.pop();
//        }
        return answer;
    }
}

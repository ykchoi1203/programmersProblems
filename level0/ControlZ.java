package programmersProblum.level0;

public class ControlZ {
    public static void main(String[] args) {
        System.out.println(solution("1 2 Z 3 4 Z Z "));
    }

    public static int solution(String s) {
        int answer = 0;
        if(s.length() == 0)
            return 0;
        String[] strArr = s.split(" ");

        // 커서 위치를 만들어서 다음에 Z가 들어왔을 때 지울 숫자 위치를 표시
        String[] numArr = new String[strArr.length];
        int cursor = 0;
        for(int i=0; i<strArr.length; i++){
            if(cursor != 0 && strArr[i].equals("Z")){
                numArr[cursor-1] = "0";
                cursor--;
            } else if (!strArr[i].equals("Z")) {
                numArr[cursor] = strArr[i];
                cursor++;
            }
        }
        for(int i=0; i<cursor; i++){
            answer += Integer.parseInt(numArr[i]);
        }


//        // String 으로 푼게 속도가 느려서 StringBuilder를 사용하여 속도를 높여봄
//        StringBuilder sb = new StringBuilder();
//        for(int i=0; i<strArr.length; i++){
//            if(sb.length() != 0 && strArr[i].equals("Z")){
//                int index = sb.lastIndexOf(" ");
//                if(index == -1) sb.setLength(0);
//                else sb.setLength(index);
//            } else if(!strArr[i].equals("Z")) {
//                if(sb.length() == 0)
//                    sb.append(strArr[i]);
//                else
//                    sb.append(" " + strArr[i]);
//            }
//        }
//
//        if(sb.length() == 0) return 0;
//        String numString = sb.toString();
//        for(String num : numString.split(" ")){
//            answer += Integer.parseInt(num);
//        }

//        // 문자열로 풀어보기.
//        String numString = "";
//        for(int i=0; i<strArr.length; i++){
//            if(numString.length() != 0 && strArr[i].equals("Z")){
//                int index = numString.lastIndexOf(' ');
//                if(index == -1) numString = "";
//                else numString = numString.substring(0, index); // 1 2 3
//            } else if(!strArr[i].equals("Z")) { // 1 2 3 4
//                if(numString.length() == 0)
//                    numString = strArr[i];
//                else
//                    numString += " " + strArr[i];
//            }
//        }
//        if(numString.length() == 0) return 0;
//        for(String num : numString.split(" ")){
//            answer += Integer.parseInt(num);
//        }

//        // 악으로 깡으로 배열로 풀기...
//        // 제거되면 i를 증가시키면 X
//        // 예) 맨 앞에 Z가 나오는 경우 Z를 제거하고 index 0 부터 다시 검사해야 하기 때문
//        for(int i=0; i<strArr.length;){
//            // 맨 앞에 Z가 나오는 경우 앞에 Z 제거하는 곳
//            if(i == 0 && strArr[0].equals("Z")){
//                strArr = Arrays.copyOfRange(strArr, 1, strArr.length-1);
//            }
//            else{
//                if(strArr[i].equals("Z")){
//                    // 현재 위치 Z와 그 전 배열을 제거 -> 2칸이 줄어듦.
//                    String[] copyArr = new String[strArr.length - 2];
//                    // strArr의 인덱스 0 부터 i-1 개 만큼 복사 인덱스(i-2) + 1 (개수이기때문에 1을 더해줌)
//                    System.arraycopy(strArr, 0, copyArr, 0, i-1);
//                    // strArr의 현재 인덱스 + 1 부터 strArr.length - (i-1) - 2  개를 복사. 2개가 줄기 때문에
//                    System.arraycopy(strArr, i+1, copyArr, i-1, strArr.length-i-1);
//                    strArr = copyArr;
//                    // 현재 위치보다 1칸 전것을 다시 검사해야함.
//                    // 예 ) 1 2 Z Z 가 들어왔다고 한다면 i = 2일때 검사를 하는데 2와 Z가 사라지니
//                    //      1 Z 가 남는다 -> i = 1 일때 검사를 해야하기 때문에 -1을 해줌
//                    i--;
//                }
//                else i++;   // Z가 아니면 그냥 넘기면 된다.
//            }
//        }
//        for(int i=0; i<strArr.length; i++)
//            answer += Integer.parseInt(strArr[i]);

//        // LinkedList로 풀기. ArrayList도 똑같을듯
//        LinkedList<Integer> list = new LinkedList<>();
//        for(int i=0; i < strArr.length; i++){
//            if(strArr[i].equals("Z")){
//                if(!list.isEmpty())
//                    list.remove(list.size() - 1);
//            }
//            else
//                list.add(Integer.parseInt(strArr[i]));
//        }
//        for(int i : list) {
//            answer += i;
//        }

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

package programmersProblum.level1;

public class Babbling2 {
    public static void main(String[] args) {
        String[] s = {"a", "ay", "aya", "m", "ma", "y", "ye", "w", "wo", "woo", "ayam", "ayama", "ayay","ayaye", "ayaw", "ayawo", "ayawoo"};
        System.out.println(solution(s));
    }

    public static int solution(String[] babbling) {
        int answer = 0;

        String[] babble = new String[] {"aya", "ye", "woo", "ma"};

        for(String s : babbling) {
            if(s.contains("ayaaya") || s.contains("yeye") || s.contains("woowoo") || s.contains("mama")) continue;
            for(int i=0; i<babble.length; i++) {
                s = s.replace(babble[i], " ");
            }
            s = s.replace(" ", "");
            if(s.length() == 0)
                answer++;
        }
//        // 맨 앞글자에 따라 옹알이랑 비교, 옹알이랑 다르면 break 같으면 해당 부분까지 넘어가고 다음 부분 또 비교
//        for(String s : babbling){
//            int lastWord = 0;
//            boolean isBabbling = true;
//            if(s.length() == 0)
//                isBabbling = false;
//            for(int i=0; i<s.length(); i++){
//                if(s.charAt(i) == 'a'){
//                    if(i + 2 < s.length() && s.charAt(i+1) == 'y' && s.charAt(i+2) == 'a' && lastWord != 1){
//                        lastWord = 1;
//                        i += 2;
//                    } else{
//                        isBabbling = false;
//                        break;
//                    }
//                } else if (s.charAt(i) == 'y'){
//                    if(i + 1 < s.length() && s.charAt(i+1) == 'e' && lastWord != 2){
//                        lastWord = 2;
//                        i += 1;
//                    } else{
//                        isBabbling = false;
//                        break;
//                    }
//                } else if (s.charAt(i) == 'w'){
//                    if(i + 2 < s.length() && s.charAt(i+1) == 'o' && s.charAt(i+2) == 'o' && lastWord != 3){
//                        lastWord = 3;
//                        i += 2;
//                    } else{
//                        isBabbling = false;
//                        break;
//                    }
//                } else if(s.charAt(i) == 'm'){
//                    if(i + 1 < s.length() && s.charAt(i+1) == 'a' && lastWord != 4){
//                        lastWord = 4;
//                        i += 1;
//                    } else{
//                        isBabbling = false;
//                        break;
//                    }
//                } else {
//                    isBabbling = false;
//                    break;
//                }
//            }
//            if(isBabbling)
//                answer++;
//        }



        return  answer;
    }


    // 2, 3번 런타임 에러...
    /*public static int solution(String[] babbling) {
        int answer = 0;

        for(String word : babbling){
            int lastWord = 0;
            Stack<Character> stack = new Stack<>();
            for(int i=0; i<word.length(); i++){
                stack.push(word.charAt(i));
            }
            while(!stack.isEmpty()) {
                if (stack.peek() == 'a') {
                    stack.pop();
                    if (stack.peek() == 'y' && lastWord != 1) {
                        stack.pop();
                        if (stack.peek() == 'a') {
                            stack.pop();
                            lastWord = 1;
                        } else{
                            break;
                        }
                    } else if (stack.peek() == 'm' && lastWord != 4) {
                        stack.pop();
                        lastWord = 4;
                    } else{
                        break;
                    }
                } else if (stack.peek() == 'e' && lastWord != 2) {
                    stack.pop();
                    if (stack.peek() == 'y') {
                        stack.pop();
                        lastWord = 2;
                    } else{
                        break;
                    }
                } else if (stack.peek() == 'o' && lastWord != 3) {
                    stack.pop();
                    if (stack.peek() == 'o') {
                        stack.pop();
                        if (stack.peek() == 'w') {
                            stack.pop();
                            lastWord = 3;
                        } else{
                            break;
                        }
                    } else{
                        break;
                    }
                } else
                    break;
            }

            if(stack.isEmpty())
                answer++;
        }
        return answer;
    }*/

}

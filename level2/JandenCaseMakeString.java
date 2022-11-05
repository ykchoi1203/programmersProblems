package programmersProblum.level2;

public class JandenCaseMakeString {

    public static void main(String[] args) {
        String[] test = {"3people unFollowed me",
                "for the last week", "             3people       unFol          lowed            me                    ",
                "             3people       unFol          lowed            me                    "};
        for(String s : test){
            System.out.println(solution(s));
        }
    }


    public static String solution(String s) {
        // 처음엔 split으로 풀려고 했는데 여러 테스트 케이스에서 런타임 에러가 나옴
        // split(" ") 을 할 경우 만약 여러개의 공백이 있다면 런타임 에러가 난다...
        // 두번째로 문제를 잘못 이해해서 공백이 여러개 있을 때 하나만 넘겨주고 앞뒤엔 공백이 없도록
        // 설계하여 만들었는데 그게 아니라 공백 갯수는 있는대로 찍어주고 앞뒤 공백도 있어도 그냥 넘겨주는 거였음.
        String answer = "";
        int upper = 'a' - 'A';
        boolean isBlank = true;
        StringBuilder sb = new StringBuilder();
        s = s.toLowerCase();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            if (sChar >= '0' && sChar <= '9') {
                isBlank = false;
                sb.append(sChar + "");
            } else if (sChar == ' ') {
                isBlank = true;
                sb.append(" ");
            } else {
                if (isBlank == true) {
                    sChar -= upper;
                    sb.append(sChar + "");
                    isBlank = false;
                } else {
                    sb.append(sChar + "");
                }
            }
        }


        return sb.toString();
    }

}

/*
    // 아예 하나하나 스플릿 받아서 넘겨주기. -> 공백으로 나눌 필요가 없었다...
    // flag를 통해 좀전이 공백이였는지 확인하고 공백이였다면 대문자(숫자는 대문자로 바꿔도 안바뀌니깐..) 아니면 그냥 더하기
    // 나중에 StringBuilder 로 하면 속도가 더 빠를거 같긴하다.
    String answer = "";
    String[] sp = s.toLowerCase().split("");
    boolean flag = true;

    for(String ss : sp) {
        answer += flag ? ss.toUpperCase() : ss;
        flag = ss.equals(" ") ? true : false;
    }

    return answer;
*/

package programmersProblum.level1;

public class GetMiddleWord {
    public static void main(String[] args) {
        System.out.println("abcde의 가운데 글자는 " + solution("abced"));
        System.out.println("qwer의 가운데 글자는 " + solution("we"));
    }

    public static String solution(String s) {
        return s.length() % 2 == 0 ?
                ("" + s.charAt(s.length() / 2 -1)) + s.charAt(s.length() / 2) : "" + s.charAt(s.length() / 2);
    }
}

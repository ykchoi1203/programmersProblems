package programmersProblum.level1;

public class OddEven {
    public static void main(String[] args) {
        System.out.println(2 + "는 " + solution(2) + "입니다.");
        System.out.println(1 + "는 " + solution(1) + "입니다.");
    }

    public static String solution(int num) {
        return num%2==0 ? "Even" : "Odd";
    }

}
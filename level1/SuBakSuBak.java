package programmersProblum.level1;

public class SuBakSuBak {
    public static void main(String[] args) {
        System.out.println(solution(5));
    }
    public static String solution(int n) {
        return n % 2 == 0 ? "수박".repeat(n/2) : "수박".repeat(n/2) + "수";
    }
}

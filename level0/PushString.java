package programmersProblum.level0;

public class PushString {
    public static void main(String[] args) {
        System.out.println(solution("hello", "ohell"));
        System.out.println(solution("apple", "elppa"));
    }

    public static int solution(String A, String B) {
        for(int i=0; i<A.length(); i++){
            if(A.equals(B))
                return i;
            A = "" + A.charAt(A.length()-1) + A.substring(0, A.length()-1);
        }

        return -1;
    }
}

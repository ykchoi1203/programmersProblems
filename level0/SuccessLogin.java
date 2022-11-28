package programmersProblum.level0;

import java.util.Arrays;

public class SuccessLogin {
    public static void main(String[] args) {
        System.out.println(solution(new String[] {"meosseugi", "1234"}, new String[][] {{"rardss", "123"}, {"yyoom", "1234"}, {"meosseugi", "1234"}}));
    }
    public static String solution(String[] id_pw, String[][] db) {
        String[] arr = Arrays.stream(db).filter(el -> el[0].equals(id_pw[0])).flatMap(Arrays::stream).toArray(String[]::new);

        if(arr.length == 0) return "fail";
        else if(arr[1].equals(id_pw[1])) return "login";
        else return "wrong pw";
    }
}

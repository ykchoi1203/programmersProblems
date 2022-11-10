package programmersProblum.level1;

public class Year2016 {

    public static void main(String[] args) {
        System.out.println(solution(5, 24));
        System.out.println(solution(12, 31));
    }

    public static String solution(int a, int b) {
        String[] answer = new String[] {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int i = 1;
        int sum = 0;
        while(i < a){
            if(i == 2)
                sum += 29;
            else if(i == 4 || i == 6 || i == 9 || i == 11)
                sum += 30;
            else sum += 31;
            i++;
        }


        return answer[(sum + b - 1) % 7];
    }
}

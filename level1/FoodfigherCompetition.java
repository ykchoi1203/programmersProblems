package programmersProblum.level1;

public class FoodfigherCompetition {
    public static void main(String[] args) {
        int[] food = {1, 3, 4, 6};
        System.out.println(solution(food));

    }

    public static String solution(int[] food) {
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<food.length; i++){
            if(food[i]/2 > 0){
                sb.append(Integer.toString(i).repeat(food[i]/2));
            }
        }
        String s = sb.reverse().toString();
        sb.reverse();
        sb.append("0");
        sb.append(s);
        //s = sb.toString() + "0" + sb.reverse().toString() 으로 하는 방법도 있다.


        return sb.toString();
    }
}

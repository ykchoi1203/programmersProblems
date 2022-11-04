package programmersProblum.level1;

public class MbtiTest {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5,3,2,7,5}));
        System.out.println(solution(new String[]{"TR", "RT", "TR"}, new int[]{7,1,3}));
    }

    public static String solution(String[] survey, int[] choices) {

        int[] cnt = new int[4];
        for(int i=0; i<survey.length; i++){
            int num = idNum(survey[i].charAt(0));
            if(survey[i].charAt(0) == 'T' || survey[i].charAt(0) == 'F' ||
                    survey[i].charAt(0) == 'M' || survey[i].charAt(0) == 'N')
                cnt[num] += -choices[i] +4;
            else
                cnt[num] += choices[i] -4;
        }


        return mbtis(cnt);
    }
    public static int idNum(char c){
        if(c=='T' || c == 'R')
            return 0;
        else if(c=='C' || c == 'F')
            return 1;
        else if(c=='J' || c == 'M')
            return 2;
        else
            return 3;
    }
    public static String mbtis(int[] cnt){
        String[] mbtis = {"RT", "CF", "JM","AN"};
        String answer = "";
        for(int i=0; i<cnt.length; i++){
            if(cnt[i] > 0){
                answer += mbtis[i].charAt(1);
            } else{
                answer += mbtis[i].charAt(0);
            }
        }
        return answer;

    }
}

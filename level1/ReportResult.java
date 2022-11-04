package programmersProblum.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ReportResult {
    public static void main(String[] args) {
        String[] s = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;
        int[] result = solution(s, report, k);
        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, ArrayList<String>> reportMap = new HashMap<>();
        int[] cnt = new int[id_list.length];
        for(String rep : report){
            String id = rep.split(" ")[0];
            String repo = rep.split(" ")[1];

            if(reportMap.containsKey(id)){
                if(!reportMap.get(id).contains(repo)){
                    ArrayList<String> cloneAl = reportMap.get(id);
                    cloneAl.add(repo);
                    reportMap.put(id, cloneAl);
                }
            } else{
                ArrayList<String> aL = new ArrayList<>();
                aL.add(repo);
                reportMap.put(id, aL);
            }
        }

        for(String reportId : reportMap.keySet()){
            ArrayList<String> aL =reportMap.get(reportId);
            for(String s : aL){
                int where = Arrays.asList(id_list).indexOf(s);
                cnt[where]++;
            }
        }

        for(int i=0; i<cnt.length; i++){
            if(cnt[i] >= k){
                for(String s : reportMap.keySet()){
                    if(reportMap.get(s).contains(id_list[i])){
                        int where = Arrays.asList(id_list).indexOf(s);
                        answer[where]++;
                    }
                }
            }
        }

        return answer;
    }
}
/* 첫 코드 20/100
int[][] result = new int[id_list.length][id_list.length];
int[] result2 = new int[id_list.length];

HashSet<String> remove = new HashSet<>();

for(String i : report)
    remove.add(i);

for(String s : remove){
    String[] splitRemove = s.split(" ");
    String userId = splitRemove[0];
    String reportId = splitRemove[1];
    int l=0;
    while(!reportId.equals(id_list[l]))
        l++;
    if(result2[l] >= k)
        continue;
    int j=0;
    while(!userId.equals(id_list[j]))
        j++;

    result[j][l] = 1;
    result2[l] += 1;

}

for(int i=0; i<result2.length; i++){
    if(result2[i] >= k){
        for(int j=0; j<id_list.length; j++){
            if(result[j][i] == 1){
                answer[j]++;
            }
        }
    }
}*/
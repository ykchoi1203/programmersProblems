package programmersProblum.level1;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WhoDidNotFinish {
    public static void main(String[] args) {
        System.out.println(solution(new String[] {"mislav", "stanko", "mislav", "ana"}, new String[] {"stanko", "ana", "mislav"}));
    }
    public static String solution(String[] participant, String[] completion) {
        Map<String, Long> map = Arrays.stream(participant).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//        Map<String, Long> map2 = Arrays.stream(completion).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//        Set<String> keySet = map1.keySet();
//        for(String key : keySet) {
//            if(!map2.containsKey(key)) return key;
//            else if(map2.get(key) != map1.get(key)) return key;
//        }
//        HashMap<String, Integer> map = new HashMap<>();
//        for(String name : participant) map.put(name, map.getOrDefault(name, 0) + 1);
        for(String name : completion) map.put(name, map.get(name) -1);

        Set<Map.Entry<String, Long>> entry = map.entrySet();
        for(Map.Entry<String, Long> el : entry){
            if(el.getValue() != 0) return el.getKey();
        }


        Arrays.sort(participant);
        Arrays.sort(completion);
        for(int i=0; i<completion.length; i++) {
            if(!completion[i].equals(participant[i])) return participant[i];
        }

        return "";

    }
}

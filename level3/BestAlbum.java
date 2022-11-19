package programmersProblum.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class BestAlbum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
                new String[] {"classic", "pop", "classic", "classic", "pop"},
                new int[] {500, 600, 150, 800, 2500})));
    }


    public static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        HashMap<String, Integer> hashmap = new HashMap<>();

        for(int i=0; i<genres.length; i++) {
            if(hashmap.containsKey(genres[i])) {
                hashmap.put(genres[i], hashmap.get(genres[i]) + plays[i]);
            } else hashmap.put(genres[i], plays[i]);
        }

        String[] genre = new String[hashmap.size()];
        int[] play = new int[hashmap.size()];
        int i=0;
        for(Map.Entry<String, Integer> entry : hashmap.entrySet()) {
            genre[i] = entry.getKey();
            play[i] = entry.getValue();
            i++;
        }

        for(int j = 0; j < genre.length; j++) {
            for(int k = j + 1; k < genre.length; k++) {
                if(play[j] < play[k]) {
                    int temp = play[j];
                    play[j] = play[k];
                    play[k] = temp;

                    String sTemp = genre[j];
                    genre[j] = genre[k];
                    genre[k] = sTemp;
                }
            }
        }

        ArrayList<Integer> al = new ArrayList<>();
        for(String g : genre) {
            int max = -1;
            int nextMax = -1;
            int maxIndex = -1;
            int nextMaxIndex = -1;
            for(int j=0; j<genres.length; j++) {
                if(genres[j].equals(g)) {
                    if(nextMax < plays[j]) {
                        if(max < plays[j]) {
                            nextMax = max;
                            max = plays[j];
                            nextMaxIndex = maxIndex;
                            maxIndex = j;
                        } else {
                            nextMax = plays[j];
                            nextMaxIndex = j;
                        }
                    }
                }
            }
            al.add(maxIndex);
            if(nextMaxIndex != -1) {
                al.add(nextMaxIndex);
            }
        }

        return al.stream().flatMapToInt(num-> IntStream.of(num)).toArray();
    }
}

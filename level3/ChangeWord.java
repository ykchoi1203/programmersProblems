package programmersProblum.level3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class ChangeWord {

    public static void main(String[] args) {
        System.out.println(solution("hit","cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
    }

    public static int solution(String begin, String target, String[] words) {
        if(!hasWord(target, words)) return 0;
        int[] hasChange = new int[words.length];
        Queue<String> queue = new LinkedList<>();
        queue.add((begin));
        while (!queue.isEmpty()) {
            String currentWord = queue.poll();
            int currentIdx = Arrays.stream(words).collect(Collectors.toList()).indexOf(currentWord);
            if(currentWord.equals(target)) break;
            for(int i=0; i<words.length; i++) {
                if(hasChange[i] == 0) {
                    int cnt = 0;
                    for (int j = 0; j < words[i].length(); j++) {
                        if (currentWord.charAt(j) != words[i].charAt(j)) {
                            cnt++;
                        }
                    }
                    if (cnt == 1) {
                        queue.add(words[i]);
                        if(currentIdx != -1) {
                           hasChange[i] = hasChange[currentIdx] + 1;
                        } else {
                            hasChange[i] = 1;
                        }
                    }
                }
            }
        }


        return hasChange[Arrays.stream(words).collect(Collectors.toList()).indexOf(target)];
    }

    public static boolean hasWord(String target, String[] words) {
        for(int i=0; i<words.length; i++) {
            if(words[i].equals(target))
                return true;
        }

        return false;
    }
}

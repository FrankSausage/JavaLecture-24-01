package EX99_Board.Q3;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("blue", 96);
        map.put("hong", 86);
        map.put("white", 92);

        String name = null;     // 최고 점수를 받은 아이디
        int maxScore = 0;       // 최고 점수
        int totalScore = 0;     // 점수 합계

        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        for(Map.Entry<String, Integer> entry: entrySet){
            int newMaxScore = entry.getValue();

            if(newMaxScore >= maxScore){
                maxScore = newMaxScore;
                name = entry.getKey();
                totalScore += newMaxScore;
            }
        }
        System.out.printf("평균점수: %d%n최고점수: %d%n최고점수를 받은 아이디: %s%n", totalScore/2, maxScore, name);

    }
}

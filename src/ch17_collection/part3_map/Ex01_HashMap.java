package ch17_collection.part3_map;

import java.util.*;
import java.util.Map;

public class Ex01_HashMap {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("사과", 1500); map.put("배", 2500); map.put("감", 1000);
        map.put("배", 3000);             // map 안에 key 값이 없으면 생성, 있으면 값 수정
        System.out.println(map);

        // 추출
        System.out.println(map.get("사과"));               // Key로 값 얻기

        // 정보 추출
        System.out.println(map.containsValue("배") + ", " + map.containsValue(4000));

        // key의 Set collection - 권장하는 방법
        Set<String> keySet = map.keySet();
        for (String key: keySet){
            System.out.println(key + ": " + map.get(key));
        }

        // Entry의 Set collection
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        for(Map.Entry<String, Integer> entry: entrySet){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("========================= Stream으로 처리");
        map.forEach((k, v) -> System.out.println(k + ": " + v));

        // 삭제
        map.remove("감");
        System.out.println(map.size());
        map.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}

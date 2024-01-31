package extra_api;

import java.util.Map;

public class MapMain {
    public static void main(String[] args) throws Exception {
        RoadAddrApi road = new RoadAddrApi();
        KakaoLocalApi kakao = new KakaoLocalApi();
        String[] places = {"경기도청", "장안구청", "팔달구청", "영통구청"};
        for(String place: places){
            String roadAddr = road.getRoadAddr(place);
            Map<String, Double> geoCode = kakao.getGeoCode(roadAddr);
            System.out.printf("%s: %s, %.6f, %.6f%n",place, roadAddr, geoCode.get("lat"), geoCode.get("lon"));
        }

    }
}

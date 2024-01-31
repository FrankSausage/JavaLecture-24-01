package extra_api;

import com.sun.net.httpserver.HttpHandler;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpHeaders;
import java.util.HashMap;
import java.util.Map;

/*
 *
 * 도로명 주소로부터 위도(latitude), 경도(longitude) 정보를 구해주는 메소드
 */
public class KakaoLocalApi {

    public Map<String, Double> getGeoCode(String addr) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("c:/Test/kakaoApiKey.txt"));
        String kakaoKey = br.readLine();
        br.close();
        String query = URLEncoder.encode(addr, "utf-8");
        String apiUrl = "https://dapi.kakao.com/v2/local/search/address.json"
                      + "?query=" + query;
        URL url = new URL(apiUrl);
        // 헤더 설정
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        conn.setRequestMethod("GET");
        conn.setRequestProperty("Authorization", "KakaoAK " + kakaoKey);
//        conn.setRequestProperty("Authorization");
//        conn.setDoOutput(true);
//        conn.setUseCaches(false);
//        conn.setDefaultUseCaches(false);

        // 응답 결과 확인
//        int responseCode = conn.getResponseCode();
//        System.out.println(responseCode);
//
        br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
        StringBuffer sb = new StringBuffer();
        String line = null;
        while ((line = br.readLine()) != null){
            sb.append(line);
        }
        br.close();
//        System.out.println(sb.toString());

        // JSON 데이터에서 원하는 값 추출하기
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(sb.toString());
        JSONArray documents = (JSONArray) object.get("documents");
        JSONObject item = (JSONObject) documents.get(0);
//        System.out.println(item.keySet()); // [address, address_type, x, y, address_name, road_address]
        String lon_ = (String) item.get("x");
        String lat_ = (String) item.get("y");
//        System.out.println(lon_ + ", " + lat_);

        Map<String, Double> map = new HashMap<>();
        map.put("lon", Double.parseDouble(lon_));
        map.put("lat", Double.parseDouble(lat_));

        return map;
    }
}

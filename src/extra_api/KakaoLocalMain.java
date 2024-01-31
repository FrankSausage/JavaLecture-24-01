package extra_api;

public class KakaoLocalMain {
    public static void main(String[] args) throws Exception {
        KakaoLocalApi kakao = new KakaoLocalApi();
        System.out.println(kakao.getGeoCode("경기도 수원시 영통구"));
    }
}

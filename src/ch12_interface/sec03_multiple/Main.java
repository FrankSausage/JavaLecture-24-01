package ch12_interface.sec03_multiple;

import ch12_interface.sec02_interface.RemoteControllable;

public class Main {

	public static void main(String[] args) {
		RemoteControllable rc = new SmartTV();
		rc.turnOn();
		rc.setVolume(5);
		rc.turnOff();
		
		Searchable sc = new SmartTV();
		sc.search("www.youtube.com");
		
		SmartTV stv = new SmartTV();
		stv.turnOn();
		stv.setVolume(10);
		stv.turnOff();
		stv.search("youtube.com");
		
		sc = new Searchable() {
			@Override
			public void search(String url) {
				System.out.println("익명 구현체가 " + url + " 을/를 검색을 합니다.");
			}
		};
		sc.search("kakao");
		
	}

}

package ch12_interface.sec02_interface;

public class Audio implements RemoteControllable {
	private int volume;

	@Override
	public void turnOn() {
		System.out.println("Audio를 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("Audio를 끕니다.");

	}

	@Override
	public void setVolume(int volume) {
		if (volume > RemoteControllable.MAX_VOLUME) {
			this.volume = RemoteControllable.MAX_VOLUME;
		}
		else if (volume < RemoteControllable.MIN_VOLUME) {
			this.volume = RemoteControllable.MIN_VOLUME;
		}
		else {
			this.volume = volume;
		}
		
		System.out.println("현재 Audio 볼륨: " + this.volume);
	}
}

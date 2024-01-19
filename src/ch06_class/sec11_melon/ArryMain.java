package ch06_class.sec11_melon;

public class ArryMain {

	public static void main(String[] args) {
		MelonChart[] mel = new MelonChart[5];
		
		mel[0] = new MelonChart(1, "비의 랩소디", "임재현", "비의 랩소디", 33195);
		mel[1] = new MelonChart(2, "To. X", "태연", "To. X - The 5th Mini Album", 82788);
		mel[2] = new MelonChart(3, "Perfect Night", "르세라핌", "Perfect Night", 94989);
		mel[3] = new MelonChart(4, "Drama", "aespa", "Drama - The 4th Mini Album", 68533);
		mel[4] = new MelonChart(5, "에피소드", "이무진", "에피소드", 33236);
		
		for (int i = 0; i < mel.length; i++) {
			System.out.println(mel[i]);
		}
		
		
		InterparkBS[] ipBS = new InterparkBS[5];
		ipBS[0] = new InterparkBS(1, "처음부터 시작하는 주식투자 단타전략", "홍인기", "길벗", 18900 );
		ipBS[1] = new InterparkBS(2, "마흔에 읽는 쇼펜하우어", "강용수", "유노북스", 15300 );
		ipBS[2] = new InterparkBS(3, "세이노의 가르침", "세이노", "데이원", 6480 );
		ipBS[3] = new InterparkBS(4, "이처럼 사소한 것들", "Claire Keegan", "홍한별", "다산책방", 12420 );
		ipBS[4] = new InterparkBS(5, "내가 생각한 인생이 아니야", "류시화", "수오서재", 16200 );
		
		for (int i = 0; i < ipBS.length; i++) {
			System.out.println(ipBS[i]);
		}
	}

}

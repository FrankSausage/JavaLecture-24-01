package ch06_class.sec11_melon;

public class MelonChart {
	private int rank;
	private String title;
	private String artist;
	private String album;
	private int like;
	
	public MelonChart() { }
	
	public MelonChart(int rank, String title, String artist, String album, int like) {
		this.rank = rank;
		this.title = title;
		this.artist = artist;
		this.album = album;
		this.like = like;
	}

	@Override
	public String toString() {
		return "MelonChart [rank=" + rank + ", title=" + title + ", artist=" + artist + ", album=" + album + ", like="
				+ like + "]";
	}
	
}

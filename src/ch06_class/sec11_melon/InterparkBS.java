package ch06_class.sec11_melon;

public class InterparkBS {
	int rank;
	String title;
	String author;
	String translator;
	String company;
	int price;
	
	public InterparkBS () { }
	
	public InterparkBS(int rank, String title, String author, String company, int price) {
		this.rank = rank;
		this.title = title;
		this.author = author;
		this.company = company;
		this.price = price;
	}
	
	public InterparkBS(int rank, String title, String author, String translator, String company, int price) {
		this.rank = rank;
		this.title = title;
		this.author = author;
		this.translator = translator;
		this.company = company;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "InterparkBS [rank=" + rank + ", title=" + title + ", author=" + author + ((translator == null) ? "" : (", translator=" + translator)) 
				+ ", company=" + company + ", price=" + String.format("%,d", price) + "]";
	}
}

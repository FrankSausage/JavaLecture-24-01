package EX99_Message;

public class Message {
	private String mid;
	private String content;
	private String writer;
	private int genTime;
	private int isDeleted;
	
	
	public Message(String mid, String content, String writer, int genTime, int isDeleted) {
		super();
		this.mid = mid;
		this.content = content;
		this.writer = writer;
		this.genTime = genTime;
		this.isDeleted = isDeleted;
	}


	public String getMid() {
		return mid;
	}


	public void setMid(String mid) {
		this.mid = mid;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}


	public int getGenTime() {
		return genTime;
	}


	public void setGenTime(int genTime) {
		this.genTime = genTime;
	}


	public int getIsDeleted() {
		return isDeleted;
	}


	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	
	
}

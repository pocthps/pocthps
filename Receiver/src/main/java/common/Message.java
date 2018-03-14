package common;

public class Message {

	private String to;
	private String body;
	private long sentTime;

	public Message() {
	}

	public Message(String to, String body) {
		this.to = to;
		this.body = body;
		sentTime = System.currentTimeMillis();
	}
	public Message(String to, String body, long sentTime) {
		this.to = to;
		this.body = body;
		this.sentTime = sentTime;
	}

	public String getBody() {
		return body;
	}

	public long getSentTime() {
		return sentTime;
	}

	public String getTo() {
		return to;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public void setSentTime(long sentTime) {
		this.sentTime = sentTime;
	}

	public void setTo(String to) {
		this.to = to;
	}

	@Override
	public String toString() {
		return String.format("Message{to=%s, body=%s, sentTime=%s}", getTo(), getBody(), getSentTime());
	}

}

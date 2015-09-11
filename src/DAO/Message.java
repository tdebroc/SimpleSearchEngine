package DAO;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONObject;

import com.datastax.driver.core.Row;


public class Message {
	private String idMessage;
	
	private String content;
	
	private Long idUser1;
	
	private Long idUser2;
	
	private boolean isUser1TheTarget;
	
	private Date creationDate;
	
	private Date readDate;
	
	public Message(String idMessage, String content) {
		this.idMessage = idMessage;
		this.content = content;
	}
	
	public Message(Row row) {
		this.idMessage = buildIdMessage(row.getString("usr1"),
				row.getString("usr2"), row.getString("timestamp"));
		this.content = row.getString("cnt");
	}
	
	public String buildIdMessage(String user1, String user2, String timestamp) {
		return user1 + "-" + user2 + "-" + timestamp;
	}

	public String getIdMessage() {
		return idMessage;
	}

	public void setIdMessage(String idMessage) {
		this.idMessage = idMessage;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getIdUser1() {
		return idUser1;
	}

	public void setIdUser1(Long idUser1) {
		this.idUser1 = idUser1;
	}

	public Long getIdUser2() {
		return idUser2;
	}

	public void setIdUser2(Long idUser2) {
		this.idUser2 = idUser2;
	}

	public boolean isUser1TheTarget() {
		return isUser1TheTarget;
	}

	public void setUser1TheTarget(boolean isUser1TheTarget) {
		this.isUser1TheTarget = isUser1TheTarget;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getReadDate() {
		return readDate;
	}

	public void setReadDate(Date readDate) {
		this.readDate = readDate;
	}

	@Override
	public String toString() {
		return "Message [idMessage=" + idMessage + ", content=" + content + "]";
	}
	
	public static JSONObject messageListToJson(List<Message> messages) {
		// TODO Implement it.
		return new JSONObject();
	}
}

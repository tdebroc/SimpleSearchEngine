package DAO;

public class Conversation {
	private String idConversation;

	public String getIdConversation() {
		return idConversation;
	}

	public void setIdConversation(String idConversation) {
		this.idConversation = idConversation;
	}
	
	public static String getUser1(String idConversation) {
		return idConversation.split("-").length == 2 ? idConversation.split("-")[0] : null;
	}
	
	public static String getUser2(String idConversation) {
		return idConversation.split("-").length == 2 ? idConversation.split("-")[1] : null;
	}
}

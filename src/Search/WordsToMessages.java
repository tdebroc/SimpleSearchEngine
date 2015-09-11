package Search;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DAO.Message;

public class WordsToMessages {
	
	private Long creationDate;

	private Map<String, List<Message>> wordToMessages = new HashMap<String, List<Message>>();
	
	/**
	 * 
	 * @param word
	 * @return
	 */
	public List<Message> find(String word) {
		return wordToMessages.get(word);
	}
	
	/**
	 * 
	 * @param word
	 * @param idMessage
	 */
	public void addWord(String word, Message message) {
		if (wordToMessages.containsKey(word)) {
			wordToMessages.get(word).add(message);
		} else {
			List<Message> messages = new ArrayList<Message>();
			messages.add(message);
			wordToMessages.put(word, messages);
		}
	}

	public Long getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Long creationDate) {
		this.creationDate = creationDate;
	}
}
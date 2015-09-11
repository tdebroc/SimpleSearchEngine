package Search;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DAO.Message;
import DAO.MessagesCassandraDAO;


public class SearchEngine {

	/**
	 * Interval for flushing all map. 
	 */
	private int flushInterval = 30 * 1000;
	
	private static Map<String, WordsToMessages> conversationsToWords = new HashMap<String, WordsToMessages>();
	
	private static MessagesCassandraDAO messagesCassandraDAO;
	
	public static void init(MessagesCassandraDAO messagesCassandraDAO) {
		launchMapFlusher();
		SearchEngine.messagesCassandraDAO = messagesCassandraDAO;
	}
	
	
	private static void launchMapFlusher() {
		// Launch Task every "flushInterval" ms to flush old maps of words.
		
	}


	/**
	 * 
	 * @param idConversation
	 * @param word
	 * @return
	 */
	public static List<Message> find(String idConversation, String word) {
		WordsToMessages wordsToMessages = conversationsToWords.get(idConversation);
		if (wordsToMessages == null) {
			buildWordsToMessages(idConversation);
		}
		return conversationsToWords.get(idConversation).find(word);
		
	}
	
	/**
	 * 
	 * @param idConversation
	 */
	public static void buildWordsToMessages(String idConversation) {
		WordsToMessages wordsToMessages = new WordsToMessages();
		List<Message> messages = messagesCassandraDAO.find(idConversation);
		for (Message message : messages) {
			String[] words = message.getContent().split(" ");
			for (String word : words) {
				// TODO: Apply Stemming, Ascci folding, remove punctions...
				wordsToMessages.addWord(word, message);
			}
		}
		conversationsToWords.put(idConversation, wordsToMessages);
	}


	public int getFlushInterval() {
		return flushInterval;
	}


	public void setFlushInterval(int flushInterval) {
		this.flushInterval = flushInterval;
	}
	
	
}




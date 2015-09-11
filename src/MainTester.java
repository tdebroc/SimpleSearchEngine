import java.util.List;

import DAO.Message;
import DAO.MessagesCassandraDAO;
import Search.SearchEngine;


public class MainTester {

	public static void main(String[] args) {
		
		testSearchEngine();
	}

	
	public static void testSearchEngine() {
		MessagesCassandraDAO messagesCassandraDao = new MessagesCassandraDAO();
		SearchEngine.init(messagesCassandraDao);
		
		searchAndPrintMessages("oui");
		searchAndPrintMessages("bonjour");
		searchAndPrintMessages("blabla");
		
//		System.out.println("Search Hello: " + );
		
	}
	
	public static void searchAndPrintMessages(String word) {
		List<Message> messages = SearchEngine.find("3", word);
		if (messages == null) {
			System.out.println("No result for '" + word + "' ");
			return;
		}
		System.out.println("Result for '" + word + "': ");
		for (Message message: messages) {
			System.out.println(" - " + message);
		}
	}
}

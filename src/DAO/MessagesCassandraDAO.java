package DAO;
import java.util.ArrayList;
import java.util.List;


public class MessagesCassandraDAO extends DAOCassandra<Message> {

	@Override
	public List<Message> find(String idConversation) {
		List<Message> messages = new ArrayList<Message>();
		
		// TODO: Continue link with Cassandra. Doc is here:
		// http://www.planetcassandra.org/getting-started-with-apache-cassandra-and-java/
		/*
		String user1 = Conversation.getUser1(idConversation);
		String user2 = Conversation.getUser2(idConversation);
		CassandraSession.getCassandraSession().execute("SELECT FROM messages WHERE lastname = 'Jones'");
		// Show that the user is gone
		String sql = "SELECT * FROM messages WHERE usr1 = " + user1 + " AND usr2 = " + user2 + "";
		ResultSet results = CassandraSession.getCassandraSession().execute(sql);
		for (Row row : results) {
			messages.add(new Message(row));
		}
		*/
		
		
		messages.add(new Message("1", "bonjour ca va?"));
		messages.add(new Message("2", "oui et toi?"));
		messages.add(new Message("3", "oui all is good. what you do u do?"));
		messages.add(new Message("4", "a big thing!!"));
		messages.add(new Message("5", "sweeeeeet"));
		return messages;
	}



}

package DAO;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class CassandraSession {
	
	private static Cluster cluster;
	private static Session session;
	
	public static Session getCassandraSession() {
		if (session == null) {
			cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
			session = cluster.connect("happnDb");
		}
		return session;
	} 
}

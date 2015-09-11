package DAO;
import java.util.List;


public abstract class DAOCassandra<T> {
	public abstract List<T> find(String id);


}

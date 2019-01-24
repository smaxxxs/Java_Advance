package shared;

import java.util.List;

public interface CRUD <T>{
	T create(T t);

	T read(Integer id);

	T update(T t);

	void delete(Integer id);
	
	public List<T> readAll();

}

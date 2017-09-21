package fr.demos.formation.septiemearche.data;

import java.util.List;

public interface InterfaceDao <T> {
	public T select(String key) throws Exception;
	public List<T> selectSearch(String criteria) throws Exception;
	public List<T> selectAll() throws Exception;
	public void insert(T object) throws Exception;
	public void update(T object) throws Exception;
	public void delete(T object) throws Exception;
}

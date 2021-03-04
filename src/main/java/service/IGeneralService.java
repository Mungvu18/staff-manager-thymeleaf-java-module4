package service;


import java.util.List;

public interface IGeneralService <T> {
    List<T> findAll();
    boolean create(T t);
    boolean delete(int id);
    boolean edit(int id, T t);
    T findById(int id);
    T findByName(String name);
}

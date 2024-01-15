package uz.pdp.db;

import java.util.List;

public interface Repository<T> {

    void save(T t); // add

    List<T> findAll(); // read

    void update(T t, Integer id); // will change the prev val to t by id
    void delete(T t);


}

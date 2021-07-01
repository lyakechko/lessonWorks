package DAO;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public interface IDao<T> {

    void save(T t) throws SQLException;

    T get(Serializable id) throws SQLException;

    void delete(T t) throws SQLException;

    T update(T t) throws SQLException;
}

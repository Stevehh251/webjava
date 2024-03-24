package cmc.WebJava.DAO;

import cmc.WebJava.relations.DefaultEntity;

import java.util.Collection;

public interface DefaultDAO<T extends DefaultEntity<ID>, ID> {
    T getById(ID id);

    Collection<T> getAll();

    T save(T entity);

    void saveCollection(Collection<T> entities);

    void delete(T entity);

    void deleteById(ID id);

    T update(T entity);
}
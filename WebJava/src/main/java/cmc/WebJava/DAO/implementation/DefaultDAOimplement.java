package cmc.WebJava.DAO.implementation;

import cmc.WebJava.relations.DefaultEntity;
import cmc.WebJava.DAO.DefaultDAO;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Collection;

@Repository
public abstract class DefaultDAOimplement<T extends DefaultEntity<ID>, ID extends Serializable> implements DefaultDAO<T, ID> {

    protected SessionFactory sessionFactory;

    protected Class<T> persistentClass;

    public DefaultDAOimplement(Class<T> entityClass){
        this.persistentClass = entityClass;
    }

    @Autowired
    public void setSessionFactory(LocalSessionFactoryBean sessionFactory) {
        this.sessionFactory = sessionFactory.getObject();
    }

    @Override
    public T getById(ID id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(persistentClass, id);
        }
    }

    @Override
    public T update(T entity) {
        T newEntity;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            newEntity = session.merge(entity);
            session.flush();
            session.getTransaction().commit();
        }
        return newEntity;
    }

    @Override
    public void delete(T entity) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.remove(entity);
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteById(ID id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            T sessionEntity = getById(id);
            session.remove(sessionEntity);
            session.getTransaction().commit();
        }
    }

    @Override
    public Collection<T> getAll() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<T> newQuery = builder.createQuery(persistentClass);
            newQuery.from(persistentClass);
            return session.createQuery(newQuery).getResultList();
        }
    }

    @Override
    public T save(T entity) {
        T sessionEntity;
        try (Session session = sessionFactory.openSession()) {
            if (entity.getId() != null) {
                entity.setId(null);
            }
            session.beginTransaction();
            sessionEntity = session.merge(entity);
            session.flush();
            session.getTransaction().commit();
        }
        return sessionEntity;
    }

    @Override
    public void saveCollection(Collection<T> entities) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            for (T entity : entities) {
                this.save(entity);
            }
            session.getTransaction().commit();
        }
    }
}
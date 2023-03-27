package ru.markush.lessonFive.starLevelSolution;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

public abstract class GenericDao<T, ID extends Serializable> {
    private final Class<T> entityType;
    private final SessionFactory sessionFactory;

    public GenericDao(Class<T> entityType, SessionFactory sessionFactory) {
        this.entityType = entityType;
        this.sessionFactory = sessionFactory;
    }

    public void create(T entity) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }
    }

    public T read(ID id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(entityType, id);
        }
    }

    public void update(T entity) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }
    }

    public void delete(T entity) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }
    }

    public List<T> findAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<T> query = session.createQuery("from " + entityType.getName(), entityType);
            return query.getResultList();
        }
    }
}
package com.learnkorealanguage.app.repository;

import com.learnkorealanguage.app.db.DBConnectionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public abstract class BaseRepository<T> {
    private final Class<T> entityClass;

    protected BaseRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected Session getSession() {
        return DBConnectionFactory.getDBSessionManager().openSession();
    }

    protected void executeTransaction(Consumer<Session> action) {
        try (Session session = getSession()) {
            Transaction ts = session.beginTransaction();
            try {
                action.accept(session);
                ts.commit();
            } catch (Exception e) {
                ts.rollback();
            }
        }
    }

    protected <R> R executeQuery(Function<Session, R> query){
        try (Session session = getSession()) {
            return query.apply(session);
        }
    }

    public void save(T entity){
        executeTransaction(session -> session.persist(entity));
    }

    public void update(T entity){
        executeTransaction(session -> session.merge(entity));
    }

    public void delete(T entity) {
        executeTransaction(session -> session.remove(session.merge(entity)));
    }

    public T findById(int id){
        return executeQuery(session -> session.find(entityClass, id));
    }
    public List<T> findAll(){
        return executeQuery(session -> session.createQuery( "FROM " + entityClass.getSimpleName() ,  entityClass ).list());
    }
}

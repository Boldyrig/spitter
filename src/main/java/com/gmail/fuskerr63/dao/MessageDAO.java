package com.gmail.fuskerr63.dao;

import com.gmail.fuskerr63.domain.Message;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class MessageDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addMessage(Message message) {
        message.setDate(new Date());
        getCurrentSession().save(message);
    }

    public void updateMessage(Message message) {
        getCurrentSession().update(message);
    }

    public Message getMessagesById(int id) {
        return getCurrentSession().get(Message.class, id);
    }

    public List<Message> getMessagesByUserId(int userId) {
        CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Message> criteriaQuery = criteriaBuilder.createQuery(Message.class);
        Root<Message> rootMessage = criteriaQuery.from(Message.class);
        criteriaQuery.select(rootMessage).where(criteriaBuilder.equal(rootMessage.get("userId"), userId));

        Query<Message> query = getCurrentSession().createQuery(criteriaQuery);
        return query.getResultList();
    }

    public List<Message> getMessages(int count) {
        CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Message> criteriaQuery = criteriaBuilder.createQuery(Message.class);
        Root<Message> rootMessage = criteriaQuery.from(Message.class);
        criteriaQuery.select(rootMessage);

        Query<Message> query = getCurrentSession().createQuery(criteriaQuery).setMaxResults(count);
        String queryString = query.getQueryString();
        return query.getResultList();
    }
}

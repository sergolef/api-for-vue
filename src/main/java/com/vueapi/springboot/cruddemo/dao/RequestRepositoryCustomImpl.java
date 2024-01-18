package com.vueapi.springboot.cruddemo.dao;

import com.vueapi.springboot.cruddemo.entity.Request;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.util.List;

public class RequestRepositoryCustomImpl implements RequestRepositoryCustom{
    @Autowired
    @Lazy
    RequestRepository requestRepository;

    @PersistenceContext
    private EntityManager entityManager;

//    @Autowired
//    public RequestRepositoryCustomImpl(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }

//    @Override
//    public List<Request> findRequestsByCoachId(int coachId) {
//
//        TypedQuery<Request> q = entityManager.createQuery("Select s from Coach c " +
//                "JOIN FETCH c.requests " +
//                "where c.id = :id", Student.class);
//
//        q.setParameter("sid", id);
//        return q.getSingleResult();
//
//        return null;
//    }

    public List<Request> findRequestsForCoach(int id) {
        TypedQuery<Request> query = entityManager.createQuery("from Requests where coach.id=:coachId", Request.class);

        query.setParameter("coachId", id);
        List<Request> requests = query.getResultList();
        return requests;
    }
}

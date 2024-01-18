package com.vueapi.springboot.cruddemo.dao;

import com.vueapi.springboot.cruddemo.entity.Request;

import java.util.List;

public interface RequestRepositoryCustom {
//    public List<Request> findRequestsByCoachId(int coachId);
    public List<Request> findRequestsForCoach(int id);
}


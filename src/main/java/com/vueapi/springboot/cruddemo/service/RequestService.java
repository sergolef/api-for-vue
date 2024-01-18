package com.vueapi.springboot.cruddemo.service;

import com.vueapi.springboot.cruddemo.entity.Coach;
import com.vueapi.springboot.cruddemo.entity.Request;

import java.util.List;

public interface RequestService {

    List<Request> findAllForCoach(int coachId);

    List<Request> findAll();

    Request findById(int theId);

    Request save(Request theRequest);

    void deleteById(int theId);

}

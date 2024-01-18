package com.vueapi.springboot.cruddemo.service;

import com.vueapi.springboot.cruddemo.entity.Coach;

import java.util.List;

public interface CoachService {

    List<Coach> findAll();

    Coach findById(int theId);

    Coach save(Coach theCoach);

    void deleteById(int theId);

}

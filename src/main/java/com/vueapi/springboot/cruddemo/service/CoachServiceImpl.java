package com.vueapi.springboot.cruddemo.service;

import com.vueapi.springboot.cruddemo.dao.CoachRepository;
import com.vueapi.springboot.cruddemo.entity.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoachServiceImpl implements CoachService {

    private CoachRepository coachRepository;

    @Autowired
    public CoachServiceImpl(CoachRepository theCoachRepository) {
        coachRepository = theCoachRepository;
    }

    @Override
    public List<Coach> findAll() {
        return coachRepository.findAll();
    }

    @Override
    public Coach findById(int theId) {
        Optional<Coach> result = coachRepository.findById(theId);

        Coach theCoach = null;

        if (result.isPresent()) {
            theCoach = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find coach id - " + theId);
        }

        return theCoach;
    }

    @Override
    public Coach save(Coach theCoach) {
        return coachRepository.save(theCoach);
    }

    @Override
    public void deleteById(int theId) {
        coachRepository.deleteById(theId);
    }
}







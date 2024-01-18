package com.vueapi.springboot.cruddemo.service;

import com.vueapi.springboot.cruddemo.dao.CoachRepository;
import com.vueapi.springboot.cruddemo.dao.RequestRepository;
import com.vueapi.springboot.cruddemo.entity.Coach;
import com.vueapi.springboot.cruddemo.entity.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    public RequestServiceImpl(RequestRepository theRequestRepository) {
        requestRepository = theRequestRepository;
    }

    @Override
    public List<Request> findAllForCoach(int coachId) {
        return requestRepository.findRequestsForCoach(coachId);
    }

    @Override
    public List<Request> findAll() {
        return requestRepository.findAll();
    }

    @Override
    public Request findById(int theId) {
        Optional<Request> result = requestRepository.findById(theId);

        Request theRequest = null;

        if (result.isPresent()) {
            theRequest = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find request id - " + theId);
        }

        return theRequest;
    }

    @Override
    public Request save(Request theRequest) {
        return requestRepository.save(theRequest);
    }

    @Override
    public void deleteById(int theId) {
        requestRepository.deleteById(theId);
    }
}







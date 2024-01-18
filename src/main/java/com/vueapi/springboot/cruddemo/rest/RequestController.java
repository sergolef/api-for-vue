package com.vueapi.springboot.cruddemo.rest;

import com.vueapi.springboot.cruddemo.entity.Coach;
import com.vueapi.springboot.cruddemo.entity.Request;
import com.vueapi.springboot.cruddemo.service.CoachService;
import com.vueapi.springboot.cruddemo.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RequestController {

    private RequestService requestService;

    @Autowired
    public RequestController(RequestService theRequestService) {
        this.requestService = theRequestService;
    }

    @GetMapping("/request/{coachId}.json")
    public List<Request> findAllForCoach(@PathVariable int coachId) {
        return requestService.findAllForCoach(coachId);
    }

    @GetMapping("/request.json")
    public List<Request> findAll() {
        return requestService.findAll();
    }

    @PostMapping("/request.json")
    public Request addRequest(@RequestBody Request theRequest) {
        System.out.println("========================================");
        System.out.println(theRequest);
        System.out.println("========================================");
        theRequest.setId(0);

        Request dbRequest = requestService.save(theRequest);

        return dbRequest;
    }
}

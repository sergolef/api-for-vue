package com.vueapi.springboot.cruddemo.rest;

import com.vueapi.springboot.cruddemo.entity.Coach;
import com.vueapi.springboot.cruddemo.entity.Request;
import com.vueapi.springboot.cruddemo.service.CoachService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coach")
@CrossOrigin
public class CoachController {

    private CoachService coachService;

    @Autowired
    public CoachController(CoachService theCoachService) {
        this.coachService = theCoachService;
    }

    @GetMapping
    public List<Coach> findAll() {
        return coachService.findAll();
    }


    @PostMapping
    public Coach addCoach(@RequestBody Coach theCoach) {

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        theCoach.setId(0);

        Coach dbCoache = coachService.save(theCoach);

        return dbCoache;
    }

    @GetMapping("/{coachId}/requests.json")
    public List<Request> getCoachRequests(@PathVariable int coachId) {
        Coach paticularCoach = coachService.findById(coachId);
        List<Request> requests = paticularCoach.getRequests();
        if(requests == null){
            System.out.println("No Requests found");
        }
        return requests;
    }
}

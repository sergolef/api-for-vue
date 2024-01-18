package com.vueapi.springboot.cruddemo.entity;

import jakarta.persistence.*;


import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="coaches")
public class Coach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="firstName")
    private String firstName;

    @Column(name="lastName")
    private String lastName;

    @Column(name="description")
    private String description;

    @Column(name="hourlyRate")
    private int hourlyRate;

    public String getFirstName() {
        return firstName;
    }

    @Override
    public String toString() {
        return "Coach{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", description='" + description + '\'' +
                ", hourlyRate=" + hourlyRate +
                ", areas=" + areas +
                ", requests=" + requests +
                '}';
    }

    public Coach() {
    }

    public Coach(String firstName, String lastName, String description, int hourlyRate, List<Area> areas, List<Request> requests) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
        this.hourlyRate = hourlyRate;
        this.areas = areas;
        this.requests = requests;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public List<Area> getAreas() {
        return areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;

    }


    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name="coach_areas",
            joinColumns = @JoinColumn(name="coach_id"),
            inverseJoinColumns = @JoinColumn(name="area_id"))
    private List<Area> areas;


    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name="coachId")
    private List<Request> requests;


    public void addRequest(Request theRequest){
        if(requests == null){
            requests = new ArrayList<>();
        }
        requests.add(theRequest);
    }

    public void addArea(Area theArea){
        if(areas == null){
            areas = new ArrayList<>();
        }
        areas.add(theArea);
    }
}

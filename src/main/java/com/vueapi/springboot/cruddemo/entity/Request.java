package com.vueapi.springboot.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="coaches_requests")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    public Request() {
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", message='" + message + '\'' +
                '}';
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Request(String email, String message, int coachId) {
        this.email = email;
        this.message = message;
        this.coachId = coachId;
    }

    @Column(name="email")
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="message")
    private String message;

    @Column(name="coachId")
    private int coachId;

    public int getCoachId() {
        return coachId;
    }

    public void setCoachId(int coachId) {
        this.coachId = coachId;
    }
}

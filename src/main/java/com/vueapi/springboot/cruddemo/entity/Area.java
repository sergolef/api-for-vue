package com.vueapi.springboot.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="areas")
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Area{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public Area(String name) {
        this.name = name;
    }

    public Area() {
    }

    @Column(name="name")
    private String name;

}

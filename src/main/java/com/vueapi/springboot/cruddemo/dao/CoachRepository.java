package com.vueapi.springboot.cruddemo.dao;

import com.vueapi.springboot.cruddemo.entity.Coach;
import jakarta.persistence.TypedQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoachRepository extends JpaRepository<Coach, Integer> {

}

package com.vueapi.springboot.cruddemo.dao;

import com.vueapi.springboot.cruddemo.entity.Area;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaRepository extends JpaRepository<Area, Integer> {
}

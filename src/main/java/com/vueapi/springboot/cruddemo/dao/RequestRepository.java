package com.vueapi.springboot.cruddemo.dao;

import com.vueapi.springboot.cruddemo.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, Integer>, RequestRepositoryCustom{
}

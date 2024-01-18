package com.vueapi.springboot.cruddemo.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class EggBoilerServiceImpl implements EggBoilerService{
    @Override
    public void boilEgs() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

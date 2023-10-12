package com.example.gae.healthchecks.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gae.api.health_checks.controller.HealthCheckApi;

@RestController
@RequestMapping("/materials-api/v1")
public class HealthChecksApiController implements HealthCheckApi {
    
    public ResponseEntity<Map<String, String>> healthCheckGet(){
        Map<String,String> result = new HashMap<>();
        result.put("liveliness", "ok");
        return new ResponseEntity<Map<String,String>>(result, HttpStatus.OK);
    }
}

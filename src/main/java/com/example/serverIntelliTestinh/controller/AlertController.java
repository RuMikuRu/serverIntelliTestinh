package com.example.serverIntelliTestinh.controller;

import com.example.serverIntelliTestinh.model.Alert;
import com.example.serverIntelliTestinh.model.User;
import com.example.serverIntelliTestinh.servive.AlertService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping
public class AlertController {
    private final AlertService service;


    public AlertController(AlertService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Alert>> getAll() throws FileNotFoundException, JsonProcessingException {
        return ResponseEntity.ok(Arrays.asList(service.getAll()));
    }

    @RequestMapping(path = "/add",method = RequestMethod.POST)
    public void addAlert(@RequestBody Alert newAlert) throws IOException {
        service.addAlert(newAlert);
    }
}

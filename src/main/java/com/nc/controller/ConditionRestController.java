package com.nc.controller;

import com.nc.entity.Condition;
import com.nc.entity.Location;
import com.nc.repository.ConditionRepository;
import com.nc.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@RestController
public class ConditionRestController {

    @Autowired
    private ConditionRepository  conditionRepository;

    @Autowired
    private LocationRepository locationRepository;

    @GetMapping("/conditions")
    public String addCondition(){
        return "conditions";
    }
    @PostMapping("/conditions")
    public String addCondition(@RequestParam(value = "location", required = true)Integer location, @RequestParam Integer temp,
                               @RequestParam Integer hum, @RequestParam Integer co2){

        Condition condition = new Condition();
        condition.setTimestamp(new Timestamp(System.currentTimeMillis()));
        condition.setTemp(temp);
        condition.setHum(hum);
        condition.setCo2(co2);
        condition.setLocation(locationRepository.findById(location));
        conditionRepository.save(condition);
        return "conditions";
    }
}

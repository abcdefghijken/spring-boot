package com.ken.springcoredemo.rest;

import com.ken.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;

    @Autowired
    public DemoController(@Qualifier("trackCoach") Coach theCoach) {
        this.myCoach = theCoach;
    }

//    @Autowired
//    public DemoController(@Qualifier("baseballCoach") Coach theCoach) {
//        this.myCoach = theCoach;
//    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return this.myCoach.getDailyWorkout();
    }
}

package com.mdfaysalhossain.SMS.With.Maven.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controller {

    @GetMapping("")
    public String home(){
        return "homepage";
    }

    @GetMapping("/stAttendance")
    public String stAttendance(){
        return "stAttendance";
    }


    @GetMapping("/student/stClassRutineAdd")
    public String stClassRutineAdd(){
        return "stClassRutineAdd";
    }
}

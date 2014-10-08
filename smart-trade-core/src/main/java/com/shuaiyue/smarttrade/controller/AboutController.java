package com.shuaiyue.smarttrade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AboutController {

    @Autowired
    @Qualifier("appName")
    protected String applicationName;

    @RequestMapping(value = "/about.html")
    @ResponseBody
    public String about() throws Exception {
        return this.applicationName + " is up and running!";
    }

}

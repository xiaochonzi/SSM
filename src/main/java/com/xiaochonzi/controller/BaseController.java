package com.xiaochonzi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;

/**
 * Created by stone on 17/8/15.
 */
@Controller
public class BaseController {

    @RequestMapping(value = "/{page}")
    public String page(@RequestPart("page")String page){
        return page;
    }
}

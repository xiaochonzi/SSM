package com.xiaochonzi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by stone on 17/6/18.
 */
@Controller
public class BaseController {

    @RequestMapping("/{form}")
    public String redirect(@PathVariable("form")String form){
        return form;
    }
}

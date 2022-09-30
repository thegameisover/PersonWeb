package com.springMVC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@ResponseBody
@Controller
public class TEST {
    @RequestMapping("/test")
    public String ceshi()
    {
        return "1";
    }
}

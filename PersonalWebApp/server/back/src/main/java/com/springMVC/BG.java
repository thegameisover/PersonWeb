package com.springMVC;

import com.alibaba.fastjson.JSONObject;
import com.mybatis.BGMapper;
import com.mybatis.PassageMapper;
import com.mybatis.UserMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ResponseBody
@Controller
public class BG {
    @RequestMapping(value = "/BG",method = RequestMethod.GET)
    public void bg(HttpServletRequest request, HttpServletResponse response)
    {
        String UserName = request.getParameter("name");
        String BG = request.getParameter("bg");
        ApplicationContext context =new ClassPathXmlApplicationContext("beans.xml");
        BGMapper bg =context.getBean("BGMapper", BGMapper.class);
        if((bg.GetBG(UserName))==null)
        {
            bg.SetBG(UserName,BG);
        }
        else
        {
            bg.AlertBG(UserName,BG);
        }
    }
}

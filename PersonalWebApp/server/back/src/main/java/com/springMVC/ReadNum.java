package com.springMVC;

import com.mybatis.PassageMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ReadNum {
    @RequestMapping(value = "/num",method = RequestMethod.GET)
    public void Num(HttpServletRequest request)
    {
        String Name=request.getParameter("name");
        System.out.println(Name);
        ApplicationContext context =new ClassPathXmlApplicationContext("beans.xml");
        PassageMapper passageMapper =context.getBean("PassageMapper",PassageMapper.class);
        int p = passageMapper.GetNUm(Name);
        p=p+1;
        passageMapper.AlertNum(Name,p);
    }
}

package com.springMVC;

import com.JavaClass.Passage;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mybatis.BGMapper;
import com.mybatis.PassageMapper;
import com.mybatis.UserMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
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
public class MainWindow {
    @RequestMapping(value = "/main",method= RequestMethod.GET)
    public String mianWindow(HttpServletRequest request, HttpServletResponse response)
    {
        Cookie[] cookie =request.getCookies();
        String name=null;
        if(cookie!=null)//判断是否存在cookie
        {
            String CookieName=null;
            String CookieValue=null;
            for(Cookie cookie1:cookie)
            {
                CookieName= cookie1.getName();
                CookieValue=cookie1.getValue();
            }
            ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
            UserMapper userMapper =context.getBean("userMapper",UserMapper.class);
            //往json中添加数据
            JSONObject jsonObject = new JSONObject();
            if((name=userMapper.UserName(CookieName,CookieValue))!=null)
            {
                jsonObject.put("name",name);
            }
            else
            {
                jsonObject.put("name","null");
            }
            PassageMapper passageMapper=context.getBean("PassageMapper",PassageMapper.class);
            List<Map<String,Object>> list = passageMapper.searchPassage();
            int i=0;
            while(i<list.size())
            {
                List<Object> list1=new ArrayList<>();
                list1.add(list.get(i).get("title"));
                list1.add(list.get(i).get("picture"));
                list1.add(list.get(i).get("writer"));
                list1.add(list.get(i).get("writeDate"));
                list1.add(list.get(i).get("readNum"));
                list1.add(list.get(i).get("commentNum"));
                jsonObject.put("passage"+i,list1);
                i++;
            }
            jsonObject.put("num",i);
            BGMapper bgMapper = context.getBean("BGMapper",BGMapper.class);
            String picture=bgMapper.GetPicture(name);
            jsonObject.put("Picture",picture);
            return jsonObject.toJSONString();
        }
        else
        {
            ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name","null");
            PassageMapper passageMapper=context.getBean("PassageMapper",PassageMapper.class);
            List<Map<String,Object>> list = passageMapper.searchPassage();
            int i=0;
            while(i<list.size())
            {
                List<Object> list1=new ArrayList<>();
                list1.add(list.get(i).get("title"));
                list1.add(list.get(i).get("picture"));
                list1.add(list.get(i).get("writer"));
                list1.add(list.get(i).get("writeDate"));
                list1.add(list.get(i).get("readNum"));
                list1.add(list.get(i).get("commentNum"));
                jsonObject.put("passage"+i,list1);
                i++;
            }
            jsonObject.put("num",i);

            return jsonObject.toJSONString();
        }

    }
}

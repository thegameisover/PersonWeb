package com.springMVC;

import com.JavaClass.Passage;
import com.alibaba.fastjson.JSONObject;
import com.mybatis.PassageMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ResponseBody
@Controller
public class Search {
    @RequestMapping(value = "/Search",method = RequestMethod.GET)
    public String search(HttpServletRequest request, HttpServletResponse response)
    {
        JSONObject jsonObject = new JSONObject();
        String data=request.getQueryString();
        data=data.substring(data.indexOf("=")+1);
        data='%'+data+'%';
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        PassageMapper passageMapper = context.getBean("PassageMapper", PassageMapper.class);
        List<Map<String,Object>> list =passageMapper.PassageName(data);
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

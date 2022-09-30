package com.springMVC;

import com.alibaba.fastjson.JSONObject;
import com.mybatis.PassageMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
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
public class NextPage {
    @RequestMapping(value = "/nextPassage",method= RequestMethod.GET)
    public String nextPage(HttpServletRequest request, HttpServletResponse response)
    {

        String getHead = request.getQueryString();
        int j=getHead.indexOf("=");
        String data = getHead.substring(j+1);
        int page = Integer.parseInt(data);
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        PassageMapper passageMapper = context.getBean("PassageMapper",PassageMapper.class);
        List<Map<String,Object>> list =passageMapper.nextPage(page*10,page*10-10);
        JSONObject jsonObject =new JSONObject();
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

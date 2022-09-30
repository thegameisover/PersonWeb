package com.springMVC;

import com.alibaba.fastjson.JSON;
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
import java.io.*;
import java.net.URLDecoder;
import java.util.Map;

@ResponseBody
@Controller
public class Read {
    @RequestMapping(value = "/Read",method = RequestMethod.GET)
    public String ReadPassage(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        StringBuffer buffer = new StringBuffer();
        StringBuffer buffer1=new StringBuffer();
        String s=null;
        JSONObject jsonObject =new JSONObject();
        String data = request.getQueryString();
        data= data.substring(data.indexOf("=")+1);
         data= URLDecoder.decode(data,"UTF-8");
        ApplicationContext context =new ClassPathXmlApplicationContext("beans.xml");
        PassageMapper passageMapper = context.getBean("PassageMapper",PassageMapper.class);
        Map<String,Object> map = passageMapper.GetPassage(data);
        if(map.size()>0)
        {
            String address1=(String)(map.get("introduction"));
            String address2=(String)(map.get("content"));
            try {
                InputStreamReader read = new InputStreamReader(new FileInputStream(address1), "UTF-8");
                BufferedReader reader = new BufferedReader(read);
                while((s=reader.readLine())!=null)
                {
                    buffer=buffer.append(s);
                }
                InputStreamReader read1 = new InputStreamReader(new FileInputStream(address2), "UTF-8");
                BufferedReader reader1 = new BufferedReader(read1);
                while((s=reader1.readLine())!=null)
                {
                    buffer1=buffer1.append(s);
                    buffer1=buffer1.append("\r\n");
                }
                reader.close();
                read1.close();
                reader.close();
                reader1.close();
                jsonObject.put("values","1");
                jsonObject.put("title",map.get("title"));
                jsonObject.put("introduction",buffer.toString());
                jsonObject.put("content",buffer1.toString());
                return jsonObject.toJSONString();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }finally {

            }
        }
        else
        {
            jsonObject.put("values","0");
            return jsonObject.toJSONString();
        }

    }
}

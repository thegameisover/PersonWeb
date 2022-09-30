package com.springMVC;
import com.JavaClass.User;
import com.alibaba.fastjson.JSON;
import com.mybatis.UserMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;


@ResponseBody
@Controller
public class LogUp {
    @RequestMapping(value = "/logup")
    public String Logup(@RequestBody String data)  {
         String flag="0";
        try {
            String Data= URLDecoder.decode(data,"UTF-8");//将url编码的数据转为字符串
            int length=Data.length();
            Data=Data.substring(0,length-1);//去除多余的等号
            User user= JSON.parseObject(Data,User.class);
            //数据库查询
            ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
            UserMapper userMapper= context.getBean("userMapper",UserMapper.class);
            if(userMapper.exist(user.getAccount())!=null||userMapper.Getname(user.getUserName())!=null)
            {
                flag="0";
            }
            else
            {
                userMapper.logup(user.getUserName(),user.getAccount(),user.getPassword());
                if(userMapper.login(user.getAccount(),user.getPassword())!=null)
                {
                    flag="1";
                }
                else
                {
                    flag="0";
                }
            }

        } catch (UnsupportedEncodingException e) {

        }
       return flag;

    }
}

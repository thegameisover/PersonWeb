package com.springMVC;

import com.JavaClass.User;
import com.alibaba.fastjson.JSON;
import com.mybatis.UserMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/*登录*/

@ResponseBody
@Controller
public class LogIn {
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String Login( HttpServletRequest request,HttpServletResponse response) {
        //获取请求体的数据
        BufferedReader reader =null;
        StringBuilder stringBuilder = new StringBuilder();
        try{
            reader = request.getReader();
            String str=null;
            while((str=reader.readLine())!=null)
            {
                stringBuilder.append(str);
            }
            reader.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally {
            if(reader!=null)
            {
                try{
                    reader.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
       User user =JSON.parseObject(stringBuilder.toString(),User.class);
        //查询数据据库信息
        ApplicationContext context =new ClassPathXmlApplicationContext("beans.xml");
        UserMapper userMapper =context.getBean("userMapper",UserMapper.class);
        if(userMapper.login(user.getAccount(),user.getPassword())!=null)
        {
            Cookie cookie =new Cookie(user.getAccount(), user.getPassword());
            cookie.setMaxAge(24*30*30*60);
            cookie.setPath("/");
            response.addCookie(cookie);
            return "true";
        }
        else
        {
            return "false";
        }
    }

}

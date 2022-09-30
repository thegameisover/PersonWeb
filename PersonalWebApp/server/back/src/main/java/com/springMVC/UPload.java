package com.springMVC;

import com.JavaClass.Passage;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mybatis.PassageMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLDecoder;
import java.util.Base64;

@ResponseBody
@Controller
public class UPload {
    @RequestMapping(value = "/load",method = RequestMethod.POST)
    public String UpLoad(HttpServletRequest request,HttpServletResponse response ) throws IOException {
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

        Passage passage = JSON.parseObject(stringBuilder.toString(),Passage.class);
        if(passage==null||passage.getWriterDate()==null)
        {
            return "0";
        }

if(passage.getPicture().equals("null"))
{
    String pictureAddress="null";
    String PassageAddress="/root/passage/passage/"+passage.getTitle()+".txt";
    String ContentAddress="/root/passage/content/"+passage.getTitle()+".txt";
    OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("/root/passage/passage/"+passage.getTitle()+".txt"),"UTF-8");
    BufferedWriter  bufferedWriter= new BufferedWriter(osw);
    bufferedWriter.write(passage.getIntroduction());
    bufferedWriter.flush();
    bufferedWriter.close();
    OutputStreamWriter osw1 = new OutputStreamWriter(new FileOutputStream("/root/passage/content/"+passage.getTitle()+".txt"),"UTF-8");
    BufferedWriter  bufferedWriter1= new BufferedWriter(osw1);
    bufferedWriter1.write(passage.getContent());
    bufferedWriter1.flush();
    bufferedWriter1.close();
    ApplicationContext context =new ClassPathXmlApplicationContext("beans.xml");
    PassageMapper passageMapper =context.getBean("PassageMapper",PassageMapper.class);
    passageMapper.SetPassage(passage.getTitle(),PassageAddress,pictureAddress,ContentAddress,passage.getWriter(),passage.getWriterDate(),0,0);
    return "1";
}
else
{

    String picture = passage.getPicture().substring((passage.getPicture().indexOf(",")+1));
    byte[] data =Base64.getDecoder().decode(picture);
    String pictureAddress= passage.getTitle()+".jpg";
    String PassageAddress="/root/passage/passage/"+passage.getTitle()+".txt";
    String ContentAddress="/root/passage/content/"+passage.getTitle()+".txt";
    OutputStream out = new FileOutputStream("/usr/local/nginx/html/PersonalWebApp/web/Main/"+passage.getTitle()+".jpg");
    out.write(data);
    out.flush();
    out.close();
    OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("/root/passage/passage/"+passage.getTitle()+".txt"),"UTF-8");
    BufferedWriter  bufferedWriter= new BufferedWriter(osw);
    bufferedWriter.write(passage.getIntroduction());
    bufferedWriter.flush();
    bufferedWriter.close();
    OutputStreamWriter osw1 = new OutputStreamWriter(new FileOutputStream("/root/passage/content/"+passage.getTitle()+".txt"),"UTF-8");
    BufferedWriter  bufferedWriter1= new BufferedWriter(osw1);
    bufferedWriter1.write(passage.getContent());
    bufferedWriter1.flush();
    bufferedWriter1.close();
    ApplicationContext context =new ClassPathXmlApplicationContext("beans.xml");
    PassageMapper passageMapper =context.getBean("PassageMapper",PassageMapper.class);
    passageMapper.SetPassage(passage.getTitle(),PassageAddress,pictureAddress,ContentAddress,passage.getWriter(),passage.getWriterDate(),0,0);
    return "1";
}
    }
}

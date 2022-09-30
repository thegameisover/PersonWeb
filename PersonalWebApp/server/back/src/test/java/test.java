import com.JavaClass.User;
import com.alibaba.fastjson.JSONObject;
import com.mybatis.BGMapper;
import com.mybatis.PassageMapper;
import com.mybatis.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;
import java.util.List;
import java.util.Map;

public class test {
    @Test
    public void tse() throws IOException {
        ApplicationContext context =new ClassPathXmlApplicationContext("beans.xml");
        PassageMapper passageMapper = context.getBean("PassageMapper",PassageMapper.class);
        Map<String,Object> map = passageMapper.GetPassage("mybatis中#{}和${}");
        System.out.println(map);
    }
}

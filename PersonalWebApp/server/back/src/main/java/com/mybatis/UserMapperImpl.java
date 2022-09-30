package com.mybatis;

import org.mybatis.spring.SqlSessionTemplate;

public class UserMapperImpl implements UserMapper{
    private SqlSessionTemplate sqlSession;
    public void setSqlSession(SqlSessionTemplate sqlSession)
    {
        this.sqlSession=sqlSession;
    }
    //登录
    @Override
    public String login(String account,String password) {
       UserMapper mapper=sqlSession.getMapper(UserMapper.class);
       return mapper.login(account,password);
    }
//注册
    @Override
    public void logup(String name, String account, String password) {
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
         mapper.logup(name,account,password);

    }
//注册时判断是否账号重复
    @Override
    public String exist(String account) {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        return mapper.exist(account);
    }

    @Override
    public String UserName(String account, String password) {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        return mapper.UserName(account,password);
    }

    @Override
    public String Getname(String name) {
        UserMapper userMapper =sqlSession.getMapper(UserMapper.class);
        return userMapper.Getname(name);
    }
}

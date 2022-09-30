package com.mybatis;

import org.mybatis.spring.SqlSessionTemplate;

public class BGMapperImpl implements BGMapper{
    private SqlSessionTemplate sqlSession;
    public void setSqlSession(SqlSessionTemplate sqlSession)
    {
        this.sqlSession=sqlSession;
    }

    @Override
    public void SetBG(String name, String address) {
        BGMapper bgMapper =sqlSession.getMapper(BGMapper.class);
        bgMapper.SetBG(name,address);
    }

    @Override
    public String GetBG(String name) {
        BGMapper bgMapper =sqlSession.getMapper(BGMapper.class);
        return bgMapper.GetBG(name);
    }

    @Override
    public void AlertBG(String name,String address) {
       BGMapper bgMapper=sqlSession.getMapper(BGMapper.class);
       bgMapper.AlertBG(name,address);
    }

    @Override
    public String GetPicture(String name) {
        BGMapper bgMapper =sqlSession.getMapper(BGMapper.class);
        return bgMapper.GetPicture(name);
    }
}

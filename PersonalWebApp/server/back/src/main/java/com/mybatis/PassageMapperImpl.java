package com.mybatis;

import com.JavaClass.Passage;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;
import java.util.Map;

public class PassageMapperImpl implements PassageMapper{
    private SqlSessionTemplate sqlSession;
    public void setSqlSession(SqlSessionTemplate sqlSession)
    {
        this.sqlSession=sqlSession;
    }
    @Override
    public List<Map<String, Object>> searchPassage() {
        PassageMapper passageMapper =sqlSession.getMapper(PassageMapper.class);
        return passageMapper.searchPassage();
    }

    @Override
    public List<Map<String, Object>> nextPage(int max, int min) {
        PassageMapper passageMapper =sqlSession.getMapper(PassageMapper.class);
        return passageMapper.nextPage(max,min);
    }

    @Override
    public int SetPassage(String title, String introduction, String picture, String content, String writer, String writerDate, int readNum, int commentNum) {
        PassageMapper passageMapper =sqlSession.getMapper(PassageMapper.class);
        return passageMapper.SetPassage( title,  introduction, picture, content,  writer,  writerDate,  readNum,  commentNum);
    }

    @Override
    public Map<String, Object> GetPassage(String name) {
        PassageMapper passageMapper = sqlSession.getMapper(PassageMapper.class);
        return passageMapper.GetPassage(name);
    }

    @Override
    public List<Map<String, Object>> PassageName(String name) {
        PassageMapper passageMapper =sqlSession.getMapper(PassageMapper.class);
        return passageMapper.PassageName(name);
    }

    @Override
    public void AlertNum(String name, int data) {
        PassageMapper passageMapper =sqlSession.getMapper(PassageMapper.class);
        passageMapper.AlertNum(name,data);
    }

    @Override
    public int GetNUm(String name) {
        PassageMapper passageMapper =sqlSession.getMapper(PassageMapper.class);
       return passageMapper.GetNUm(name);
    }


}

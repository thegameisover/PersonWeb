package com.mybatis;

import java.util.List;
import java.util.Map;

public interface PassageMapper {


    public List<Map<String,Object>>  searchPassage();

    public List<Map<String,Object>>  nextPage(int max,int min);

    public int SetPassage(String title ,String introduction,String picture,String content,String writer,String writerDate,int readNum,int commentNum);

    public Map<String,Object> GetPassage(String name);

    public List<Map<String,Object>> PassageName(String name);

    public void AlertNum(String name,int data);

    public int GetNUm(String name);
}

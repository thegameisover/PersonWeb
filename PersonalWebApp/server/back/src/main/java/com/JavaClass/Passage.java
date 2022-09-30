package com.JavaClass;

public class Passage {
    private String mark=null;
    private String title=null;
    private String introduction=null;
    private String picture=null;
    private String content=null;
    private String writer=null;
    private String writerDate=null;
    private int readNum=0;
    private int commentNum=0;
 public Passage()
 {

 }

 public Passage(String title,String introduction,String picture,String content,String writer,String writerDate,String mark)
 {
     this.title=title;
     this.introduction=introduction;
     this.content=content;
     this.writer=writer;
     this.writerDate=writerDate;
     this.picture=picture;
     this.mark=mark;
 }
    public void setTitle(String title) {
        this.title = title;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public void setWriterDate(String writerDate) {
        this.writerDate = writerDate;
    }

    public void setReadNum(int readNum) {
        this.readNum = readNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getMark() {
        return mark;
    }

    public String getTitle() {
        return title;
    }

    public String getIntroduction() {
        return introduction;
    }

    public String getPicture() {
        return picture;
    }

    public String getContent() {
        return content;
    }

    public String getWriter() {
        return writer;
    }

    public String getWriterDate() {
        return writerDate;
    }

    public int getReadNum() {
        return readNum;
    }

    public int getCommentNum() {
        return commentNum;
    }
}

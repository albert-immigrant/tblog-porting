package com.tangzq.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "topic")
public class Topic implements Serializable {
    private int id;
    private String title;
    private String desc;
    private String thumbURL;
    private String content;
    private int authorid;
    private int catid;
    private User_me topicauthor;
    private Category category;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return this.id;
    }

    void setId(int Id) {
        this.id = Id;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String Title) {
        this.title = Title;
    }

    @Column(name = "mydescription")
    public String getDesc() {
        return desc;
    }

    public void setDesc(String Desc) {
        this.desc = Desc;
    }

    @Column(name = "thumbURL")
    public String getThumbURL() {
        return thumbURL;
    }

    public void setThumbURL(String ThumbURL) {
        this.thumbURL = ThumbURL;
    }

    @Column(name = "Content")
    public String getContent() {
        return content;
    }

    public void setContent(String Content) {
        this.content = Content;
    }
/*
    @Column(name="authorid")
    public int getAuthorid(){return  topicauthor.getId();}
    public void setAuthorid(int Authorid){this.topicauthor.setId(Authorid);}*/

/*
    public int getCatid(){return  this.catid;}
    public void setCatid(int Catid){this.catid=Catid;}*/
/*

     @Column(name = "authorid",insertable = false,updatable = false)
     public int getAuthorid(){
         return this.authorid;
     }

    public void setAuthorid(int authorid) {
        this.authorid = authorid;
    }
*/
/*
    @ManyToOne( targetEntity = User_me.class )
    @JoinColumn(name = "authorid")
    public User_me getTopicauthor(){ return  this.topicauthor;}
    public void setTopicauthor(User_me author1){this.topicauthor=author1;}
    */

    /* @ManyToOne( targetEntity = Category.class)
     @JoinColumn(name = "catid")
     public Category getCategory(){return  this.category;}
     public void setCategory(Category mCategory){ this.category=mCategory;  }*/
    @Column(name = "catid")
    public int getCatid() {
        return this.catid;
    }

    public void setCatid(int cid) {
        this.catid = cid;
    }

    @Column(name = "authorid")
    public int getauthorid() {
        return this.authorid;
    }

    public void setauthorid(int cid) {
        this.authorid = cid;
    }
}

package com.tangzq.model;

import com.tangzq.model.embed.ReplyAuthorInfo;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
//import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author tangzhiqiang
 */
//@Document(collection = "replys")
@Entity
@Table(name = "reply")
//public class Reply extends BaseModel<String> {
public class Reply {
    private String id;
    private String topicid;
    @Column(name = "contentMD")
    private String contentMD;
    @Column(name = "contentHTML")
    private String contentHTML;
    private boolean contentishtml;
    private int thumbsUPCount;
    private boolean deleted;
    private Date Updatedate;
    private Date Createdate;
//    private User_me replyuser;
//    private Topic topicsById;

    // @OneToOne
// @JoinColumn(name = "authorInfo",referencedColumnName = "user")
    @Transient
    private ReplyAuthorInfo authorInfo;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "replyid")
    public String getReplyId() {
        return this.id;
    }

    public void setReplyId(String replyid) {
        this.id = replyid;
    }

    @Column(name = "topicid")
    public String getTopicid() {
        return this.topicid;
    }

    public void setTopicid(String topicid) {
        this.topicid = topicid;
    }

    public String getContentHTML() {
        return this.contentHTML;
    }

    public void setContentHTML(String contentHTML) {
        this.contentHTML = contentHTML;
    }

    public String getContentMD() {
        return this.contentMD;
    }

    public void setContentMD(String contentMD) {
        this.contentMD = contentMD;
    }

    /*------------------------*/
    @Column(name = "contentishtml")
    public boolean isContentIsHTML() {
        return this.contentishtml;
    }

    public void setContentIsHTML(boolean contentishtml) {
        this.contentishtml = contentishtml;
    }

    @Column(name = "thumbsUPCount")
    public void setThumbsUPCount(int thumbsUPCount) {
        this.thumbsUPCount = thumbsUPCount;
    }
    public int getThumbsUPCount() {
        return this.thumbsUPCount;
    }


    @Column(name = "deleted")
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
    public boolean isDeleted() {
        return this.deleted;
    }

    /*------------------------*/
    @Column(name = "Updatedate")
    public Date getUpdatedate() {
        return this.Updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        Updatedate = updatedate;
    }

    @Column(name = "Createdate")
    public Date getCreatedate() {
        return this.Createdate;
    }

    public void setCreatedate(Date date) {
        this.Createdate = date;
    }

    public ReplyAuthorInfo getAuthorInfo() {
        return this.authorInfo;
    }

    public void setAuthorInfo(ReplyAuthorInfo info) {
        this.authorInfo = info;
    }

    /*------------------------*/
    public String toString() {
        return "Reply(contentMD=" + this.getContentMD() +
                ", contentHTML=" + this.getContentHTML() +
                ", topicid=" + this.getTopicid() + ", replyid=" +
                this.getReplyId() + ", contentishtml="
                + this.isContentIsHTML() +
                ", thumbsUPCount=" + this.getThumbsUPCount() +
                ", deleted=" + this.isDeleted() + ")";
    }





/*
    @Column(name = "authorid",insertable = false,updatable = false)
    private int authorid ;

    public int getAuthorid() {
        return authorid;
    }

    public void setAuthorid(int authorid) {
        this.authorid = authorid;
    }
   */

 /*

    @ManyToOne(targetEntity = Topic.class)
    @JoinColumn(name = "topicid")
    public Topic getTopic(){
        return this.topicsById;
    }
    public void setTopic(Topic topids){
        this.topicsById=topids;
    }


    @ManyToOne(targetEntity = User_me.class)
    @JoinColumn(name = "authorid")
    public User_me getUser(){
        return this.replyuser;
    }
    public void setUser(User_me user1){
        this.replyuser=user1;
    }
*/
//
//    @Override
//    public boolean isNew() {
//        return getId()==null;
//    }
}

package com.tangzq.model;


import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

//import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author tangzhiqiang
 */
//@Document(collection = "category")

@ToString
@Entity
@Table(name = "category")
//public class Category extends  BaseModel<String> {
public class Category implements Serializable {


    private Long id;

    private String catdir;

    private String catname;

    private Long parentid;

 // @Column(name = "date_created",unique = true)
// private Timestamp date_created;

   //  @CreatedDate
    private Date createat;
    /*
    @OneToMany(targetEntity = User_me.class, mappedBy = "id")
    private User_me user_me;

    public User_me getUser() {
        return user_me;
    }

    public void setUser_me(User_me user_me) {
        this.user_me = user_me;
    }*/

    /*
    @Transient
    private String catname;
    @Transient
    private String catDesc;
    */


    public boolean getisNew() {
        return getId() == null;
    }
    public void setisNew() {
        ;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "catdir", unique = true)
    public String getcatdir() {
        return this.catdir;
    }
    public void setcatdir(String catDir) {
        this.catdir = catDir;
    }

    @Column(name = "cname", unique = true)
    public String getcatname() {
        return this.catname;
    }
    public void setcatname(String name) {
        this.catname = name;
    }

    @Column(name = "parent_id", unique = true)
    public Long getParent_id() {
        return this.parentid;
    }
    public void setParent_id(Long parent_id) {
        this.parentid = parent_id;
    }

    @Column(name = "createat")
    public Date getCreateat() {
        return this.createat;
    }
    public void setCreateat(Date Createat) {
        this.createat = Createat;
    }

/*

    public String getCatName() {
        return this.catname;
    }

    public void setCatName(String catName) {
        this.catname = catName;
    }
*/

/*

    public String getCatDesc(String accs_test) {
        return this.catDesc;
    }

    public void setCatDesc(String catDesc) {
        this.catDesc = catDesc;
    }
    */



}

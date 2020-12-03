package com.tangzq.repository;

import com.tangzq.model.Category;
import com.tangzq.model.Topic;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


//import org.springframework.data.mongodb.repository.Query;

/**
 * 帖子操作类
 *
 * @author tangzhiqiang
 */
@Repository

//public interface TopicRepository extends PagingAndSortingRepository<Topic,String> {
public interface TopicRepository2 extends CrudRepository<Topic, String> {

    /**
     * 查找指定用户的帖子
     *
     * @param authorId
     * @return
     */
    //  Page<Topic> findByauthorid(String authorId,Pageable pageable);
   // @Cacheable(value="links")
    Page<Topic> findAll(Pageable pageable);

    @Override
    Optional<Topic> findById(String s);
    @Query(value = "select t from Topic t where t.id=?1 ")
    Optional<Topic> findById(int s);





    //  Page<Topic> findByAuthorName(String username, Pageable pageable);

   // Page<Topic> findByTagsContains(String tagName, Pageable pageable);

  // Page<Topic> findByCatid(String tab, Pageable pageable);

     Page<Topic> findBycatid(long catid, Pageable pageable);
     Page<Topic> findTopicByCategory(Category category, Pageable pageable);

//     Page<Topic> findAllByCategoryid(long catid, Pageable pageable);

   // List<Topic> findAllByCategoryid(long catid);

//    Page<Topic> findByTitleLikeOrDescLike(String keywords, String keywords1, Pageable pageable);

 //   Page<Topic> findByCollectedUsersContains(String userId, Pageable pageable);

    /**
     * 查找指定用户的帖子
     * @param authorName
     * @param pageable
     * @return
     */
    //   Page<Topic> findByAuthorName(String authorName, Pageable pageable);

    /**
     * 查找含有指定标签的帖子
     * @param tagName
     * @param pageable
     * @return
     */
    //   Page<Topic> findByTagsContains(String tagName, Pageable pageable);

    /**
     * 按栏目分类查找
     * @param catDir
     * @param pageable
     * @return
     */
    //  Page<Topic> findByCatDir(String catDir, Pageable pageable);

    /**
     * 标题模糊查询
     * @param title
     * @param pageable
     * @return
     */
    //  Page<Topic> findByTitleLike(String title, Pageable pageable);


    /**
     * 在标题标题或者摘要模糊查询
     * @param title
     * @param desc
     * @param pageable
     * @return
     */
    //   Page<Topic> findByTitleLikeOrDescLike(String title, String desc, Pageable pageable);


    /**
     * 指定用户收藏的所有文章
     * @param userId
     * @param pageable
     * @return
     */
    //   Page<Topic> findByCollectedUsersContains(String userId, Pageable pageable);

    /**
     * 在标题标题或者摘要模糊查询
     *
     * @param words 关键字
     * @param page
     * @return
     */
    //   @Query(value = "{ $or: [ { 'title' : {$regex:?0,$options:'i'} }, { 'desc' : {$regex:?0,$options:'i'} } ] }")
//    Page<Topic> likeQuery(String words, Pageable page);
/*
    String saveSql = "insert into Topic(" +
            " catid," +
          *//*  "collectCount," +*//*
            "content," +
            "authorid"+
         *//*   "contentIsHTML," +*//*
           *//* "createdate," +
            "deleted," +*//*
            "description," +
         *//*   "good," +
            "lock," +*//*
           // "replyCount," +
            //  " tags, " +
            "thumbURL," +
            "title," +
           *//* " top," +*//*
            //        "         authorid,\n" +
            //        "           visitCount,\n" +
            "id)" +
            //       "           // values (catid:1, content:2, contentIsHTML:3, createdate:4, deleted:5, desc:6, good:7, lock:8, tags:9, thumbURL:10, title:11, top:12, ,id:13)";
          //  "values (?1,	?2,	?3,	?4,	?5,	?6,	?7,	?8,	?9,	?10,?11,?12,?13,?14)";
   //"values (:catid,:content,:authorid,:contentIsHTML,:createdate, :deleted,:desc,:good,:lock,,:thumbURL,,:title,:top,:id)";
   "values (:catid,:content,:authorid,:description,:thumbURL,:title,:id)";
            */
/*
    Topic saveMyPost(int catid,
                     String  content,
                     int authorid,
                     String description,
                     String thumbURL,
                     String title,
                     int id);

  */
/*

    @Query(value = saveSql,nativeQuery = true)

    Topic saveMyPost(int catid,
                     String  content,
                     int authorid,
                     boolean contentIsHTML,
                     boolean createdate,
                     boolean deleted,
                     String desc,
                     boolean good,
                     boolean lock,
                     String thumbURL,
                     String title,
                     boolean top,
                     //int authorid,
                     int id);
                     */

    String saveSql = "insert into Topic(catid,content,authorid,description,thumbURL,title,id)" +
            " values (:catid,:content,:authorid,:description,:thumbURL,:title,:id)" ;

    @Query(value = saveSql,nativeQuery = true)
    void saveMyPost(int catid, String content, int authorid, String description, String thumbURL, String title, int id);
}

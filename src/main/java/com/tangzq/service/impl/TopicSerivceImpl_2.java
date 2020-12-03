package com.tangzq.service.impl;

import com.tangzq.model.Category;
import com.tangzq.model.Topic;
import com.tangzq.model.User_me;
import com.tangzq.repository.TopicRepository;
import com.tangzq.repository.TopicRepository2;
import com.tangzq.repository.CategoryRepository;
import com.tangzq.service.CategoryService;
import com.tangzq.service.TopicService2;
import com.tangzq.service.UserService;
import com.tangzq.vo.IndexVo;
import com.tangzq.vo.SearchVo;
import com.tangzq.vo.TopicVo;
//import org.ehcache.core.EhcacheManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TopicSerivceImpl_2 implements TopicService2 {
    private static final String TAB_ALL = "all";
    @Autowired
    private TopicRepository2 topicRepository2;
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userService;
    @PersistenceContext
    protected EntityManager entityManager;
    @PersistenceUnit(/*unitName = "test"*/)
    private EntityManagerFactory entityManagerFactory;


    @Override
    public Page<Topic> findByPage(int pageNo, int pageSize) {
        Sort sort = Sort.by(Sort.Direction.DESC, "createdate");
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        Page<Topic> topics = topicRepository2.findAll(pageable);
        return topicRepository2.findAll(pageable);

    }

    @Override
  @Cacheable(value="links")//, key="link-test")
 //   public Page<Topic> findByPage(IndexVo vo) {
    public  List<Topic> findByPage(IndexVo vo) {
       // EhcacheManager cmm =new EhcacheManager();
        if (TAB_ALL.equals(vo.getTab())) {
            //  Sort sort = Sort.by(Sort.Direction.DESC, "top","createdate");
            Sort sort = Sort.by(Sort.Direction.DESC, "createdate");
            //  Pageable pageable = PageRequest.of(vo.getPageNO()-1, vo.getPageSize(), sort);
            Pageable pageable = PageRequest.of(vo.getPageNO() - 1, vo.getPageSize());
            Page<Topic> topics = topicRepository2.findAll(pageable);
            return (List<Topic>) topicRepository2.findAll(pageable).getContent();
        } else {

            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Query query =entityManager.createQuery("SELECT c From Category c Where c.catdir LIKE :title ");
            query.setParameter("title",vo.getTab().toString());
            query.getResultList();
          // List<Category> categories= query.getResultList();
            entityManager.flush();
            entityManager.getTransaction().commit();


            Sort sort = Sort.by(Sort.Direction.DESC, "createdate");
            // Pageable pageable = PageRequest.of(vo.getPageNO()-1, vo.getPageSize(), sort);
            Pageable pageable = PageRequest.of(vo.getPageNO() - 1, vo.getPageSize());
            List<Category> categories2 = categoryRepository.findBycatdir(vo.getTab());
//            Long id = ((Category) (categories.toArray()[0])).getId();
            Long id = new Long(1);
         //   Page<Topic> topics = topicRepository2.findBycatid(id, pageable);
            //Page<Topic> topics = topicRepository2.findByCatid(10, pageable);
            Page<Topic> topic = topicRepository2.findTopicByCategory(categories2.get(0), pageable);
            int a = 1;
            // return topicRepository2.findByCatDir(vo.getTab(),pageable);
            return (List<Topic>)  topic.getContent();
        }
    }

    @Override
    public Page<Topic> findByUsernameAndPage(String username, int pageNO, int pageSize) {
        Pageable pageable = PageRequest.of(pageNO - 1, pageSize);
        // return topicRepository.findByAuthorName(username,pageable);
        Page<Topic> topics = (Page<Topic>) topicRepository2.findAll(pageable);
        return topicRepository2.findAll(pageable);
    }

    @Override
    public TopicVo findTopicVoById(String topicID) {
        Optional<Topic> o = findTopicVoById(Integer.valueOf(topicID));
        Topic o2 = o.get();
        return convertToVo(o2);
    }

    public Optional<Topic> findTopicVoById(int topicID) {
        Optional<Topic> topic = topicRepository2.findById(topicID);

        return topicRepository2.findById(topicID);
    }

    @Override
    public Topic updateById(TopicVo vo, String id) {
        Topic topicInDB = findTopicById(id);
        if (null == topicInDB) {
            return null;
        }
        // topicInDB.setCatId(Integer.valueOf( vo.getCatId()));
        topicInDB.setTitle(vo.getTitle());
        topicInDB.setDesc(vo.getDesc());
        topicInDB.setThumbURL(vo.getThumbURL());
        /*
        if(null!=vo.getTags()){
          //  topicInDB.setTags(Arrays.asList(vo.getTags().split(",")));
        }
        */
        // topicInDB.setAuthorId(vo.getAuthorId());
        //  topicInDB.setAuthorName(vo.getAuthorName());
        topicInDB.setContent(vo.getContent());
/*
        topicInDB.setContentIsHTML(vo.isContentIsHTML());
        topicInDB.setTop(vo.isTop());
        topicInDB.setGood(vo.isGood());

        topicInDB.setUpdateAt(new Date(System.currentTimeMillis()));
        */
        Topic res=topicRepository2.save(topicInDB);
        return res;
    }

    @Override
    public void deleteById(String topicID) {

    }

    @Override
    public void increaseReplyCount(String topicid) {

    }

    @Override
    public void decreaseReplyCount(String topicId) {

    }

    @Override
    public Topic addTopic(TopicVo vo, Category category) {
        entityManager = entityManagerFactory.createEntityManager();
        User_me user1 = userService.findByUsername("admin");


        Topic topic_a = addTopic(vo);
        topic_a.setCatid(category.getId().intValue());
      //  topic_a.setCategory(category);
      //  topic_a.setTopicauthor(user1);
        categoryRepository.save(category);
        /*使用 entitymanager*/
        /*
        entityManager.getTransaction().begin();
        entityManager.persist(Topic1);
        entityManager.flush();
        entityManager.getTransaction().commit();
        */

        Topic Topic2 = topicRepository2.save(topic_a);
        // topicRepository2.saveMyPost(Topic1.getCatid(),Topic1.getContent(),Topic1.getTopicauthor().getId(),Topic1.getDesc(),Topic1.getThumbURL(),Topic1.getTitle(),Topic1.getId());
        String sql = "Insert into Topic(id,title,mydescription,thumbURL,content,authorid,catid)" +
                " SELECT  2,'我的測試文章-簡單測試寫入'," +
                " '簡單測試寫入'," +
                "'' ,'永豐金控前董事長何壽川被控涉及三寶集團超貸等弊案，台北地方法院歷經3年多審理，今天依證交法特別背信罪判處何壽川有期徒刑8年6月。全案可上訴。',1,1 " +
                "FROM Topic";
          /*  INSERT INTO `topic`(`id`, `title`, `description`, `thumbURL`, `content`, `authorid`, `catid`)
            VALUES (
                    2,'我的測試文章-簡單測試寫入', '簡單測試寫入','',
                    '永豐金控前董事長何壽川被控涉及三寶集團超貸等弊案，台北地方法院歷經3年多審理，今天依證交法特別背信罪判處何壽川有期徒刑8年6月。全案可上訴。',
                    1, 1);*/
          /*
            CriteriaBuilder cb =entityManager.getCriteriaBuilder();
            CriteriaQuery<Topic> query_topic = cb.createQuery(Topic.class);
            Root<Topic>  c= query_topic.from(Topic.class);

            Query query=entityManager.createQuery(sql);
            */
        return topic_a;
    }

    @Override
    public Topic addTopic(TopicVo vo) {


        Topic Topic1 = convertToTopic(vo);
        // Topic1.setUserByAuthorid(user1);

        // Topic1.setAuthorid(1);


        return Topic1;
    }


    @Override
    public Topic findTopicById(String topicId) {
        Optional<Topic> res =topicRepository2.findById(Integer.valueOf(topicId));
        return (Topic) res.get();
    }


    private Topic convertToTopic(TopicVo vo) {
        if (null == vo) {
            return null;
        }
        Topic Topic = new Topic();
        // topic.setAuthorId(vo.getAuthorId());
        //  topic.setAuthorName(vo.getAuthorName());

        //  Category cat=categoryService.findById(vo.getCatId());
        // topic.setCatagories(Integer.valueOf(vo.getCatId()));
        //    topic.setCatagories(cat);


        //    if(null!=cat){
        if (Topic == null) {
//            topic.setCatName(cat.getCatName());
//            topic.setCatDir(cat.getCatDir());
            //    topic.setCatName(cat.getName());
            //    topic.setCatDir(cat.getCatDir());
        }
        Topic.setTitle(vo.getTitle());
        Topic.setDesc(vo.getDesc());
        Topic.setThumbURL(vo.getThumbURL());
    /*
        if(StringUtils.isNotEmpty(vo.getTags())){
//            topic.setTags(Arrays.asList(vo.getTags().split(",")));
   //        topic.setTags(Arrays.asList(vo.getTags().split(",")).toString());
        }
        */
        Topic.setContent(vo.getContent());

       /*
        topic.setContentIsHTML(vo.isContentIsHTML());
        topic.setTop(vo.isTop());
        topic.setGood(vo.isGood());
        topic.setCreatedate(new Date(System.currentTimeMillis()));
        topic.setUpdated(new Date(System.currentTimeMillis()));*/
        /*------*/
        //  topic.setDeleted(true);

        return Topic;
    }

    private TopicVo convertToVo(Topic topic) {
        if (null == topic) {
            return null;
        }
        TopicVo vo = new TopicVo();
        vo.setTopicId(String.valueOf(topic.getId()));
        // vo.setAuthorName(topic.getAuthorName());
       // vo.setAuthorId(String.valueOf(topic.getTopicauthor().getId()));
    //    vo.setCatId(String.valueOf(topic.getTopicauthor().getId()));
        vo.setTitle(topic.getTitle());
        vo.setDesc(topic.getDesc());
        vo.setThumbURL(topic.getThumbURL());
        vo.setContent(topic.getContent());
        /*
        if(null!=topic.getTags()){

           // vo.setTags(StringUtils.join(topic.getTags(),","));
        }

        vo.setContentIsHTML(topic.isContentIsHTML());
        vo.setTop(topic.isTop());
        vo.setGood(topic.isGood());
        */
        return vo;
    }
    private int vsist=0;
    @Override
    public void increaseVisitCount(String topicID) {
        ++vsist;
    }
}

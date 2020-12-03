package com.tangzq.service;

import com.tangzq.model.Category;
import com.tangzq.model.Topic;
import com.tangzq.vo.IndexVo;
import com.tangzq.vo.TopicVo;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TopicService2 {

    Topic addTopic(TopicVo vo);
    Topic addTopic(TopicVo vo,Category category);

    Topic findTopicById(String topicId);

    Page<Topic> findByPage(int pageNo, int pageSize);

    Page<Topic> findByUsernameAndPage(String username, int pageNO, int pageSize);

    Object findTopicVoById(String topicID);

    Topic updateById(TopicVo vo, String topicID);

    void deleteById(String topicID);

    void increaseReplyCount(String topicid);

    void decreaseReplyCount(String topicId);


    Object findByPage(IndexVo vo);

    void increaseVisitCount(String topicID);
}
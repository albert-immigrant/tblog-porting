package com.tangzq;

import com.tangzq.model.Category;
import com.tangzq.vo.TopicVo;

import java.sql.Date;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;

public class MockTopic {
  private  TopicVo topicVo;
  private  Category category;


    public TopicVo getTopicVo() {
        topicVo= new TopicVo();
       // topicVo.setTopicId("4");
        topicVo.setCatId("1");
        topicVo.setTitle("我的測試文章");
        topicVo.setDesc("簡單測試寫入");
        topicVo.setThumbURL("");
       // topicVo.setTags("飛行,流行,熱銷");
        topicVo.setContent("永豐金控前董事長何壽川被控涉及三寶集團超貸等弊案，台北地方法院歷經3年多審理，今天依證交法特別背信罪判處何壽川有期徒刑8年6月。全案可上訴。");
        topicVo.setContentIsHTML(true);
        topicVo.setAuthorId("1");
        topicVo.setAuthorName("albert");
        topicVo.setTop(true);
        topicVo.setGood(true);

        return topicVo;
    }
    public Category getCategory(){
        category= new Category();
        category.setcatname("技術王");
        category.setcatdir("tech king");
        category.setParent_id(new Long(1));
        String d="2020-11-11 08:30:25";
        java.util.Date date1;
        java.sql.Date date2;
        try {
            SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
            date1=  dateFormat.parse(d);
            date2= new Date(date1.getTime());
            category.setCreateat(date2);
        } catch (Exception e){}



        return category;
    }

}

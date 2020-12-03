package com.tangzq.controller;

import com.tangzq.model.Reply;
import com.tangzq.service.ArticleService;
import com.tangzq.service.ReplyService;
import com.tangzq.service.TopicService2;
import com.tangzq.vo.ArticleVo;
import com.tangzq.vo.ReplyVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author tangzhiqiang
 */
@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private TopicService2 topicService;

    @Autowired
    private ReplyService replyService;

    @RequestMapping(value="/article/{topicID}")
    public String showArticle(@PathVariable("topicID")String topicID, ModelMap model){
        topicService.increaseVisitCount(topicID);
       ArticleVo articleVo= articleService.findArticleVo(topicID);
        model.addAttribute("article",articleVo);
       List<ReplyVo> replys = new ArrayList<ReplyVo>();
       Iterator<Reply> it= articleVo.getReplyList().listIterator();
           while (it.hasNext()){
           Reply r0=it.next();
          ReplyVo v0 =new ReplyVo();
          v0.setId(r0.getReplyId());
          v0.setTopicId(r0.getTopicid());
        //  v0.setAuthorName(r0.getAuthorInfo().getAuthorName());
          v0.setContentHTML(r0.getContentHTML());
          v0.setContentMD(r0.getContentMD());
          replys.add(v0);
           }


        model.addAttribute("replyList",replys);
        return "article/show";
    }

    @RequestMapping(value="/article/{topicID}/reply/{replyID}/del")
    public String delReply(@PathVariable("topicID")String topicID,
                              @PathVariable("replyID")String replyID){
        replyService.deleteReply(replyID,topicID);
        return "redirect:/article/"+topicID;
    }


    @RequestMapping(value = "/article/reply/{replyID}.json")
    @ResponseBody
    public Reply getReply(@PathVariable("replyID")String replyID){
        return replyService.getReply(replyID);
    }



    @RequestMapping(value="/article/{topicID}/reply/{replyID}/edit")
    public String updateReply(@PathVariable("topicID")String topicID,
                              @PathVariable("replyID")String replyID,
                              @RequestParam("editormd-edit-markdown-doc")String contentMD,
                              @RequestParam("editormd-edit-html-code")String contentHTML,
                              RedirectAttributes redirectAttributes){
        if(StringUtils.isEmpty(contentMD)&&StringUtils.isEmpty(contentHTML)){
            redirectAttributes.addFlashAttribute("messageErr","评论内容不能为空！");
            return "redirect:/article/"+topicID;
        }

        Reply updatedReply=replyService.updateReplyContent(replyID,contentMD,contentHTML);
        if(null==updatedReply||updatedReply.getReplyId()==null){
            redirectAttributes.addFlashAttribute("messageErr","评论修改失败！");
            return "redirect:/article/"+topicID;
        }else{
            redirectAttributes.addFlashAttribute("messageSuc","评论修改成功！");
            return "redirect:/article/"+topicID;
        }
    }
}

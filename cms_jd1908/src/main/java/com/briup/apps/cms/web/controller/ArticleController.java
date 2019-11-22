package com.briup.apps.cms.web.controller;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.extend.ArticleExtend;
import com.briup.apps.cms.service.IArticleService;
import com.briup.apps.cms.utils.Message;
import com.briup.apps.cms.utils.MessageUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @program: cms_jd1908
 * @description: 文章控制器类
 * @author: charles
 * @create: 2019-11-12 15:00
 **/
@Api("文章相关接口")
@Validated
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private IArticleService articleService;


    @GetMapping("findAll")
    public Message findAll(){
        List<Article> list = articleService.findAll();
        return MessageUtil.success(list);
    }

    @GetMapping("cascadeFindAll")
    public Message cascadeFindAll(){
        List<ArticleExtend>  list = articleService.cascadeFindAll();
        return MessageUtil.success(list);
    }

    @GetMapping("findById")
    public Message findById(long id){
        ArticleExtend articleExtend =  articleService.findById(id);
        return MessageUtil.success(articleExtend);
    }

   /* @ApiOperation("保存或更新")
    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(
            @ApiParam(value = "编号") @RequestParam(value = "id" ,required = false) Long id,
            @ApiParam(value = "标题",required = true) @NotNull @RequestParam(value = "title")String title,
            @ApiParam(value = "内容",required = true) @Valid @RequestParam(value = "content")String content,
            @ApiParam(value = "源内容",required = true) @RequestParam(value = "source",required = false)String source,
            @ApiParam(value = "栏目id",required = true) @RequestParam(value = "categoryId",required = false)Long categoryId,
            @ApiParam(value = "作者id",required = true) @RequestParam(value = "authorId",required = false)Long authorId){
        Article article = new Article();
        article.setId(id);
        article.setTitle(title);
        article.setContent(content);
        article.setSource(source);
        article.setCategoryId(categoryId);
        article.setAuthorId(authorId);
        articleService.saveOrUpdate(article);
        return MessageUtil.success("更新成功");
    }*/
   @ApiOperation(value = "保存或更新文章信息",notes = "如果参数中包含id后端认为是更新操作，如果参数中不包含id认为是插入操作")
   @ApiImplicitParams({
           @ApiImplicitParam(name = "id", value = "编号",paramType = "form",required = false),
           @ApiImplicitParam(name = "title", value = "标题",paramType = "form",required = true),
           @ApiImplicitParam(name = "content", value = "内容",paramType = "form",required = true),
           @ApiImplicitParam(name = "source", value = "源内容",paramType = "form",required = false),
           @ApiImplicitParam(name = "categoryId", value = "所属栏目id",paramType = "form",required = true),
           @ApiImplicitParam(name = "authorId", value = "所属作者id",paramType = "form",required = false)
   })
   @PostMapping("saveOrUpdate")
   public Message saveOrUpdate(
           Long id,
           @NotNull String title,
           @NotNull String content,
           String source,
           @NotNull long categoryId,
           Long authorId){
       Article article = new Article();
       article.setId(id);
       article.setTitle(title);
       article.setContent(content);
       article.setSource(source);
       article.setCategoryId(categoryId);
       article.setAuthorId(authorId);
       articleService.saveOrUpdate(article);
       return MessageUtil.success("更新成功");
   }



    @ApiOperation("通过id删除")
    @GetMapping("deleteById")
    public Message deleteById(@RequestParam("id") Long id){
        articleService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

}

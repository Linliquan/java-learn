package com.briup.apps.cms.bean.extend;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.Category;
import com.briup.apps.cms.bean.Comment;

import java.util.List;

/**
 * @program: cms_jd1908
 * @description: 文章拓展类
 * @author: charles
 * @create: 2019-11-12 15:06
 **/
public class ArticleExtend extends Article {
    public static final String STATUS_UNCHECK = "未审核";
    public static final String STATUS_CHECK_PASS = "审核通过";
    public static final String STATUS_CHECK_NOPASS = "审核未通过";
    private Category category;
    private List<Comment> comments;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}

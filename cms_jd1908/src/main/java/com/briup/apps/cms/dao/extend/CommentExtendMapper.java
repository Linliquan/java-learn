package com.briup.apps.cms.dao.extend;

import com.briup.apps.cms.bean.Comment;

import java.util.List;

public interface CommentExtendMapper {
    List<Comment> selectByArticleId(long article_id);
}

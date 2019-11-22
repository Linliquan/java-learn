package com.briup.apps.cms.dao.extend;

import com.briup.apps.cms.bean.extend.ArticleExtend;

import java.util.List;

public interface ArticleExtendMapper {
    List<ArticleExtend> selectAll();

    ArticleExtend selectById(long id);
}

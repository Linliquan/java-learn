package com.briup.apps.cms.service;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.extend.ArticleExtend;
import com.briup.apps.cms.utils.CustomerException;

import java.util.List;

public interface IArticleService {
    List<Article> findAll();

    List<ArticleExtend> cascadeFindAll();

    ArticleExtend findById(long id);


    void saveOrUpdate(Article article) throws CustomerException;

    void deleteById(long id) throws CustomerException;
}

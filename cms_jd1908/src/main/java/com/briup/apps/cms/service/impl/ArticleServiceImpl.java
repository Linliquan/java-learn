package com.briup.apps.cms.service.impl;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.ArticleExample;
import com.briup.apps.cms.bean.extend.ArticleExtend;
import com.briup.apps.cms.dao.ArticleMapper;
import com.briup.apps.cms.dao.extend.ArticleExtendMapper;
import com.briup.apps.cms.service.IArticleService;
import com.briup.apps.cms.utils.CustomerException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: cms_jd1908
 * @description: 文章的业务实现类
 * @author: charles
 * @create: 2019-11-12 14:59
 **/
@Service
public class ArticleServiceImpl implements IArticleService {

    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private ArticleExtendMapper articleExtendMapper;

    @Override
    public List<Article> findAll() {
        return articleMapper.selectByExample(new ArticleExample());
    }

    @Override
    public void saveOrUpdate(Article article) throws CustomerException {
        //更新
        if(article.getId() != null){
            articleMapper.updateByPrimaryKey(article);
        }else {
            ArticleExample example = new ArticleExample();
            example.createCriteria().andTitleEqualTo(article.getTitle());
            List<Article> list = articleMapper.selectByExample(example);
            if(list.size() > 0){
                throw new CustomerException("文章标题重复");
            }
            //初始化
            article.setStatus(ArticleExtend.STATUS_UNCHECK);
            article.setThumpUp(0L);
            article.setThumpDown(0L);
            article.setPublishTime(System.currentTimeMillis());
            article.setReadTimes(0L);
            //插入
            articleMapper.insert(article);
        }
    }

    @Override
    public void deleteById(long id) throws CustomerException {
        Article article = articleMapper.selectByPrimaryKey(id);
        if(article == null){
            throw new CustomerException();
        }
        articleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<ArticleExtend> cascadeFindAll() {
        return articleExtendMapper.selectAll();
    }

    @Override
    public ArticleExtend findById(long id) {

        return articleExtendMapper.selectById(id);
    }
}

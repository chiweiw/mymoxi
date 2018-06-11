package com.cww.mymoxi.service.impl;

import com.cww.mymoxi.dao.NewsMapper;
import com.cww.mymoxi.model.News;
import com.cww.mymoxi.model.NewsExample;
import com.cww.mymoxi.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 池天天
 * Date: 2018/6/3
 * Time: 10:19
 * Description:新闻页面
 */

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    NewsMapper newsMapper;


    @Override
    public News findById(News news) {

        return newsMapper.selectByPrimaryKey(news.getId());
    }

    /**
     *
     * 查找所有的新闻数据
     * */
    @Override
    public List<News> list() {
        NewsExample example = new NewsExample();
       // example.setOrderByClause("id desc");
        List<News> list = newsMapper.selectByExample(example);
        return list;
    }


    /**
     * @param news
     * 查找所有的新闻数据
     * */

    @Override
    public int count(News news) {

        return newsMapper.insert(news);
    }

    /**
     * @param news
     * 插入
     * */
    @Override
    public int insert(News news) {
        return newsMapper.insert(news);
    }

    /**
     * @param news
     * 按主键修改
     * */
    @Override
    public int update(News news) {
      return   newsMapper.updateByPrimaryKey(news);
    }

    /**
     * @param news
     * 按主键删除
     * */
    @Override
    public int delete(News news) {
        return  newsMapper.deleteByPrimaryKey(news.getId());
    }

    @Override
    public int updateState(News news) {
        return 0;
    }
}

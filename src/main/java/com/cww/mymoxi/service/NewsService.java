package com.cww.mymoxi.service;

import com.cww.mymoxi.model.News;

import java.util.List;

/**
 * @author: 池天天
 * Date: 2018/6/3
 * Time: 10:17
 * Description: 具体的文章
 */
public interface NewsService {
    News findById(News news);


    List<News> list();

    int count(News news);

    int insert(News news);

    int update(News news);

    int updateState(News news);

    int delete(News news);

}

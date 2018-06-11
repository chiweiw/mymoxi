package com.cww.mymoxi.service;

import com.cww.mymoxi.model.NewsCategory;

import java.util.List;

/**
 * @author: 池天天
 * Date: 2018/6/3
 * Time: 10:21
 * Description: 文章的分类
 */

public interface NewsCategoryService {

    NewsCategory findById(NewsCategory newsCategory);

    List<NewsCategory> list();

    List<NewsCategory> list(NewsCategory newsCategory);

    int count(NewsCategory newsCategory);

    int insert(NewsCategory newsCategory);

    int update(NewsCategory newsCategory);

    int updateState(NewsCategory newsCategory);

    int delete(NewsCategory newsCategory);


}

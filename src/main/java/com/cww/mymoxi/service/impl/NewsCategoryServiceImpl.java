package com.cww.mymoxi.service.impl;

import com.cww.mymoxi.dao.NewsCategoryMapper;
import com.cww.mymoxi.model.NewsCategory;
import com.cww.mymoxi.model.NewsCategoryExample;
import com.cww.mymoxi.service.NewsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author: 池天天
 * Date: 2018/6/3
 * Time: 10:28
 * Description:
 */
@Service
public class NewsCategoryServiceImpl  implements NewsCategoryService{

    @Autowired
    NewsCategoryMapper newsCategoryMapper;

    /**
     * 通过ID查找
     * @param newsCategory
     *
     * */
    @Override
    public NewsCategory findById(NewsCategory newsCategory) {

        return  newsCategoryMapper.selectByPrimaryKey(newsCategory.getId());
        //return null;
    }

    /**
     * 查找全部
     * */
    @Override
    public List<NewsCategory> list() {

        NewsCategoryExample example = new NewsCategoryExample();
        example.setOrderByClause("id desc");
        List<NewsCategory>  result = newsCategoryMapper.selectByExample(example);
        return result;
    }

    /**
     * 查找姓名
     * */
    @Override
    public List<NewsCategory> list(NewsCategory newsCategory) {
        NewsCategoryExample example = new NewsCategoryExample();
        example.createCriteria().andNameEqualTo(newsCategory.getName());
        List<NewsCategory>  result = newsCategoryMapper.selectByExample(example);
        return result;
    }

    @Override
    public int count(NewsCategory newsCategory) {
        return 0;
    }

    /**
     * 增加
     * @param newsCategory
     *
     * */
    @Override
    public int insert(NewsCategory newsCategory) {
        newsCategory.setAdddate(new Date());
       return newsCategoryMapper.insert(newsCategory);
    }

    /**
     * 修改
     * @param newsCategory
     *
     * */
    @Override
    public int update(NewsCategory newsCategory) {
       return newsCategoryMapper.updateByPrimaryKeySelective(newsCategory);
    }

    /**
     * 删除
     * @param newsCategory
     *
     * */
    @Override
    public int delete(NewsCategory newsCategory) {
        return newsCategoryMapper.deleteByPrimaryKey(newsCategory.getId());
      //  return 0;
    }

    @Override
    public int updateState(NewsCategory newsCategory) {
        return 0;
    }
}

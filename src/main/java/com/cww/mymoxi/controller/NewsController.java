package com.cww.mymoxi.controller;

import com.cww.mymoxi.configurer.Page;
import com.cww.mymoxi.model.JsonReturn;
import com.cww.mymoxi.model.News;
import com.cww.mymoxi.model.NewsCategory;
import com.cww.mymoxi.service.NewsCategoryService;
import com.cww.mymoxi.service.NewsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author: 池天天
 * Date: 2018/6/6
 * Time: 14:50
 * Description:  新闻页面跳转
 */

@Controller
@RequestMapping("/admin/newsDetail")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @Autowired
    private NewsCategoryService newsCategoryService;

    @RequestMapping("/newsManage")
    public String newsManage(Model model,  @RequestParam(value = "start", defaultValue = "0") int start,
                             @RequestParam(value = "size", defaultValue = "10") int size) {

        PageHelper.startPage(start, size);

        List<News> list = newsService.list();

        model.addAttribute("List", list);

        PageInfo<News> page = new PageInfo<>(list);

        page.toString();
        model.addAttribute("page", page);
        return "news/newsManage";


    }

    @GetMapping("/newsEdit")
    public String newsEditGet(Model model, News news) {
        List<NewsCategory> newsCategoryList = newsCategoryService.list();
        if (news.getId() == null) {
            news.setId(0);
        } else {
            News newsT = newsService.findById(news);
            model.addAttribute("news",newsT);

        }

        model.addAttribute("newsCategoryList", newsCategoryList);
        return "newsEdit";
    }

    @PostMapping("/newsEdit")
    public String newsEditPost(Model model, News news) {
        if (news.getId() == 0) {
            news.setAdddate(new Date());
            newsService.insert(news);
        } else {

            newsService.update(news);
        }
        return "redirect:newsManage?start=0";
    }

    @ResponseBody
    @PostMapping("/newsEditState")
    public JsonReturn newsEditState(News news){
        Integer result = newsService.delete(news);
        JsonReturn jsonReturn = new JsonReturn(result);
        return jsonReturn;
        
    }



}

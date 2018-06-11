package com.cww.mymoxi.controller;

import com.cww.mymoxi.configurer.Page;
import com.cww.mymoxi.model.JsonReturn;
import com.cww.mymoxi.model.NewsCategory;
import com.cww.mymoxi.service.NewsCategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @author: 池天天
 * Date: 2018/6/3
 * Time: 10:13
 * Description:
 */
@Controller
@RequestMapping("/admin/news")
public class NewsCategoryController {

    @Autowired
    NewsCategoryService newsCategoryService;

    @RequestMapping("/findId")
    public String findById(NewsCategory newsCategory, Model model) {


        NewsCategory news = newsCategoryService.findById((newsCategory));
        model.addAttribute(news);
        return "news/newsCategoryEdit";
    }

    @RequestMapping("/list")
    public String list(Model model, NewsCategory newsCategory,RedirectAttributes attr) {




        if (newsCategory.getName() == null) {
            List<NewsCategory> list = newsCategoryService.list();
            int total = (int) new PageInfo<>(list).getTotal();

            model.addAttribute("list", list);

            return "news/newsCategoryManage";
        }else {

            List<NewsCategory> list = newsCategoryService.list(newsCategory);
            int total = (int) new PageInfo<>(list).getTotal();
            attr.addAttribute("start", 1);

            model.addAttribute("list", list);

            return "news/newsCategoryManage";
        }



    }

    /**
     * 文章分类新增、修改跳转
     *
     * @param model
     * @param newsCategory
     * @return
     */
    @GetMapping("/newsCategoryEdit")
    public String newsCategoryEditGet(Model model, NewsCategory newsCategory) {
        if (null == newsCategory.getId()) {
            newsCategory.setId(0);

        } else {
            NewsCategory newsCategoryT = newsCategoryService.findById(newsCategory);
            model.addAttribute("newsCategory", newsCategoryT);
        }

        return "news/newsCategoryEdit";
    }

    /**
     * 文章分类新增、修改提交
     *
     * @param model
     * @param newsCategory
     * @return
     */
    @PostMapping("/newsCategoryEdit")
    public String newsCategoryEditPost(Model model, NewsCategory newsCategory) {
        if (newsCategory.getId() != 0 && null != newsCategory.getId()) {
            newsCategoryService.update(newsCategory);
        } else {
            newsCategoryService.insert(newsCategory);
        }
        return "redirect:list?start=1";
    }

    @ResponseBody
    @PostMapping("newsCategoryEditState")
    public JsonReturn newsCategoryEditState(NewsCategory newsCategory){
        Integer result = newsCategoryService.delete(newsCategory);
        JsonReturn jsonReturn  = new JsonReturn(result);
        return jsonReturn;
    }


}

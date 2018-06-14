package com.cww.mymoxi.controller;

/**
 *@author: 池天天
 *Date: 2018/5/30
 *Time: 20:46
 *Description:
 */

import com.cww.mymoxi.model.Admin;
import com.cww.mymoxi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("")
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping("/login")
    public String loginGet() {
        return "login";
    }


    /**
     * 登录
     *
     * @param admin
     * @param model
     * @param httpSession
     * @return
     */
    @PostMapping("/login")
    public String loginPost(@ModelAttribute Admin admin, Model model, HttpSession httpSession) {

        System.out.println(admin.getPassword() +"  "+admin.getUsername());
        Admin adminRes = adminService.findByNameAndPassword(admin);
        if (adminRes != null) {
            httpSession.setAttribute("admin", adminRes);
            return "redirect:dashboard";
        } else {
            model.addAttribute("error", "用户名或密码错误，请重新登录！");
            return "login";
        }

    }

    @RequestMapping("/find")
    public Admin selectByPrimaryKey(@RequestParam Integer id) {
        return adminService.selectByPrimaryKey(id);

    }

    @GetMapping("/register")
    public String registerGet(Model model) {
        return "register";
    }

    @PostMapping("/register")
    public String register(Admin admin, Model model) {
        Integer res = adminService.insert(admin);
        if (res == null) {
            model.addAttribute("error","没有添加成功，请重试");
        }
        return "login";
    }

    /**
     * 仪表板页面
     *
     * @param model
     * @return
     */
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        return "dashboard";
    }


}

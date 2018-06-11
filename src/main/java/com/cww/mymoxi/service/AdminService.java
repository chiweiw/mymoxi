package com.cww.mymoxi.service;

import com.cww.mymoxi.model.Admin;

/*
 *@author: 池天天
 *Date: 2018/5/30
 *Time: 20:36
 *Description:
 */
public interface AdminService {


    /**
     * 根据城市名称，查询城市信息
     *
     * @param id
     */
    Admin selectByPrimaryKey(Integer id);

    /**
     * 登录
     *
     * @param admin
     */
    Admin findByNameAndPassword(Admin admin);

    /***
     * 注册
     *
     * @param admin
     */

    int insert(Admin admin);

}

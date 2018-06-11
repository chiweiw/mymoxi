package com.cww.mymoxi.service.impl;

import com.cww.mymoxi.dao.AdminMapper;
import com.cww.mymoxi.model.Admin;
import com.cww.mymoxi.model.AdminExample;
import com.cww.mymoxi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/*
 *@author: 池天天
 *Date: 2018/5/30
 *Time: 20:43
 *Description:
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;
    @Override
    public Admin selectByPrimaryKey(Integer id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    @Override
    public Admin findByNameAndPassword(Admin admin) {
        AdminExample adminExample = new AdminExample();
        adminExample.createCriteria().andUsernameEqualTo(admin.getUsername()).
                andPasswordEqualTo(admin.getPassword());
        List<Admin>  result = adminMapper.selectByExample(adminExample);
        if(result.isEmpty()){
            return null;
        }
        return result.get(0);
    }

    @Override
    public int insert(Admin admin) {
        admin.setUpdatedate(new Date());
        admin.setAdddate(new Date());
        admin.setState(1);
        return adminMapper.insert(admin);
    }
}

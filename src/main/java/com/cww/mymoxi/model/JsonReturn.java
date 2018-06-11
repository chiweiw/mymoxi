package com.cww.mymoxi.model;

/**
 * @author: 池天天
 * Date: 2018/6/6
 * Time: 14:39
 * Description:  用于删除后返回一个Json数据
 */
public class JsonReturn {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public JsonReturn(Integer id) {
        this.id = id;
    }
    public JsonReturn() {

    }
}

package com.lenjoy.entity;

import java.util.Date;

public class MenuInfo {
    private Integer id;
    private String name;
    private String url;
    private Integer pId;


    public MenuInfo() {
    }

    public MenuInfo(Integer id, String name, String url, Integer pId) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.pId = pId;
    }

    /**
     * 获取
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取
     * @return pId
     */
    public Integer getPId() {
        return pId;
    }

    /**
     * 设置
     * @param pId
     */
    public void setPId(Integer pId) {
        this.pId = pId;
    }

    public String toString() {
        return "MenuInfo{id = " + id + ", name = " + name + ", url = " + url + ", pId = " + pId + "}";
    }
}

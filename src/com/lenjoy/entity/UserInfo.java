package com.lenjoy.entity;

import java.util.Date;

public class UserInfo {
private int id;
private String userName;
private String password;
private String emil;
private String money;
private Date creatTime;

    public UserInfo() {
    }

    public UserInfo(int id, String userName, String password, String emil, String money, Date creatTime) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.emil = emil;
        this.money = money;
        this.creatTime = creatTime;
    }

    /**
     * 获取
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取
     * @return emil
     */
    public String getEmil() {
        return emil;
    }

    /**
     * 设置
     * @param emil
     */
    public void setEmil(String emil) {
        this.emil = emil;
    }

    /**
     * 获取
     * @return money
     */
    public String getMoney() {
        return money;
    }

    /**
     * 设置
     * @param money
     */
    public void setMoney(String money) {
        this.money = money;
    }

    /**
     * 获取
     * @return creatTime
     */
    public Date getCreatTime() {
        return creatTime;
    }

    /**
     * 设置
     * @param creatTime
     */
    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public String toString() {
        return "UserInfo{id = " + id + ", userName = " + userName + ", password = " + password + ", emil = " + emil + ", money = " + money + ", creatTime = " + creatTime + "}";
    }
}

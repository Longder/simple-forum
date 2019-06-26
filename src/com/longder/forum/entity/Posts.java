package com.longder.forum.entity;

import java.sql.Date;

/**
 * 帖子实体类
 */
public class Posts extends BaseIdEntity{

    /**
     * 标题
     */
    private String title;

    /**
     * 发帖时间
     */
    private Date postTime;

    /**
     * 所属板块
     */
    private String category;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPostTime() {
        return postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

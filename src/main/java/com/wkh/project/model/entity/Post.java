package com.wkh.project.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 帖子
 *
 * @author wangkehua
 */
@TableName(value = "post")
@Data
public class Post implements Serializable {

    /**
     * post_id
     */
    @TableId(type = IdType.AUTO)
    private Long postId;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 创建用户 id
     */
    private Long userId;

    /**
     * 创建时间
     */
    private Date created;

    /**
     * 更新时间
     */
    private Date lastModified;

    /**
     * 是否删除
     */
    @TableLogic
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
package com.wkh.project.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户
 *
 * @author wangkehua
 */
@TableName(value = "user")
@Data
public class User implements Serializable {

    /**
     * user_id
     */
    @TableId(type = IdType.AUTO,value = "user_id")
    private Long userId;

    /**
     * 用户昵称
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 用户角色：user/admin/ban
     */
    private String userRole;

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
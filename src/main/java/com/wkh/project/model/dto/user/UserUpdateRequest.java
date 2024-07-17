package com.wkh.project.model.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户更新请求
 *
 * @author wangkehua
 */
@Data
public class UserUpdateRequest implements Serializable {
    /**
     * id
     */
    private Long userId;

    /**
     * 用户昵称
     */
    private String username;

    /**
     * 用户角色：user/admin/ban
     */
    private String userRole;

    private static final long serialVersionUID = 1L;
}
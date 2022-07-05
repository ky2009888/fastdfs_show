package com.upload.file.apps.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 自媒体用户信息表
 * @TableName wm_user
 */
@TableName(value ="wm_user")
@Data
public class WmUser  implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private Integer apUserId;

    /**
     * 
     */
    private Integer apAuthorId;

    /**
     * 登录用户名
     */
    private String name;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 头像
     */
    private String image;

    /**
     * 归属地
     */
    private String location;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 状态
            0 暂时不可用
            1 永久不可用
            9 正常可用
     */
    private Integer status;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 账号类型
            0 个人 
            1 企业
            2 子账号
     */
    private Integer type;

    /**
     * 运营评分
     */
    private Integer score;

    /**
     * 最后一次登录时间
     */
    private LocalDateTime loginTime;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        WmUser other = (WmUser) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getApUserId() == null ? other.getApUserId() == null : this.getApUserId().equals(other.getApUserId()))
            && (this.getApAuthorId() == null ? other.getApAuthorId() == null : this.getApAuthorId().equals(other.getApAuthorId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getSalt() == null ? other.getSalt() == null : this.getSalt().equals(other.getSalt()))
            && (this.getNickname() == null ? other.getNickname() == null : this.getNickname().equals(other.getNickname()))
            && (this.getImage() == null ? other.getImage() == null : this.getImage().equals(other.getImage()))
            && (this.getLocation() == null ? other.getLocation() == null : this.getLocation().equals(other.getLocation()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getScore() == null ? other.getScore() == null : this.getScore().equals(other.getScore()))
            && (this.getLoginTime() == null ? other.getLoginTime() == null : this.getLoginTime().equals(other.getLoginTime()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getApUserId() == null) ? 0 : getApUserId().hashCode());
        result = prime * result + ((getApAuthorId() == null) ? 0 : getApAuthorId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getSalt() == null) ? 0 : getSalt().hashCode());
        result = prime * result + ((getNickname() == null) ? 0 : getNickname().hashCode());
        result = prime * result + ((getImage() == null) ? 0 : getImage().hashCode());
        result = prime * result + ((getLocation() == null) ? 0 : getLocation().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getScore() == null) ? 0 : getScore().hashCode());
        result = prime * result + ((getLoginTime() == null) ? 0 : getLoginTime().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", apUserId=").append(apUserId);
        sb.append(", apAuthorId=").append(apAuthorId);
        sb.append(", name=").append(name);
        sb.append(", password=").append(password);
        sb.append(", salt=").append(salt);
        sb.append(", nickname=").append(nickname);
        sb.append(", image=").append(image);
        sb.append(", location=").append(location);
        sb.append(", phone=").append(phone);
        sb.append(", status=").append(status);
        sb.append(", email=").append(email);
        sb.append(", type=").append(type);
        sb.append(", score=").append(score);
        sb.append(", loginTime=").append(loginTime);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
package com.xzg.framework.logcenter.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
*
*  @author xzg
*/
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("log_info")
public class LogInfo implements Serializable {
    private static final long serialVersionUID = 1583139054395L;

    /**
    * 主键
    * 主键
    * isNullAble:0
    */
    private Integer id;

    /**
    * 描述
    * isNullAble:1
    */
    private String descName;

    /**
    * 用户ID
    * isNullAble:1
    */
    private Integer userId;

    /**
    * 用户姓名
    * isNullAble:0
    */
    private String userName;

    /**
    * 组织机构ID
    * isNullAble:1
    */
    private Integer orgId;

    /**
    * ip地址
    * isNullAble:1
    */
    private String ipAddress;

    /**
    * 浏览器信息
    * isNullAble:1
    */
    private String browserInfo;

    /**
    * 请求地址信息
    * isNullAble:1
    */
    private String resourceUrl;

    /**
    * 操作类型 resource：资源 menue 菜单 
    * isNullAble:1
    */
    private String type;

    /**
    * 请求方法
    * isNullAble:1
    */
    private String methondType;

    /**
    * 
    * isNullAble:1
    */
    private LocalDateTime createTime;

    /**
    * 
    * isNullAble:1
    */
    private LocalDateTime updateTime;

}

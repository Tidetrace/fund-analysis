package com.chaohen.fund.analysis.vo.uservo;

import lombok.Data;

import java.util.Date;

/**
 * 用户返回前端Vo类
 *
 * @author chaohen
 * @date 2019/9/25
 */
@Data
public class FundUserVO {
    /**  */
    private Integer id;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 用户名
     */
    private String email;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 地址
     */
    private String address;

    /**
     * 手机
     */
    private String mobile;
}

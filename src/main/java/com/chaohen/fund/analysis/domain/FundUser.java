package com.chaohen.fund.analysis.domain;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FundUser {
    /**  */
    private Integer id;

    /** 用户ID */
    private String userId;

    /** 用户名 */
    private String email;

    /**  */
    private String password;

    /** 生日 */
    private Date birthday;

    /** 地址 */
    private String address;

    /** 手机 */
    private String mobile;

    /** 状态：0禁止，1正常，-1删除 */
    private Byte status;

    /** 创建时间 */
    private Date gmtCreate;

    /** 修改时间 */
    private Date gmtModify;
}
package com.chaohen.fund.analysis.domain;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FundFlow {
    /**  */
    private Integer id;

    /** 基金主键Id */
    private String fundId;

    /** 日涨幅(百分比) */
    private Long gain;

    /** 涨幅正负：9正数，-1负数 */
    private Byte positiveOrNegative;

    /** 具体某一天 */
    private Date fundDate;

    /** 状态：0禁止，1正常，-1删除 */
    private Byte status;

    /** 创建时间 */
    private Date gmtCreate;

    /** 修改时间 */
    private Date gmtModify;
}
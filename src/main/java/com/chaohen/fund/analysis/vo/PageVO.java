package com.chaohen.fund.analysis.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页视图类
 *
 * @author chaohen
 * @date 2019/9/25
 */

@Data
public class PageVO<T> implements Serializable {


    private static final long serialVersionUID = -4764121977514423892L;

    /**
     * 页大小
     */
    private Integer pageSize;
    /**
     * 页码
     */
    private Integer pageNum;
    /**
     * 总数
     */
    private Long total;
    /**
     * 数据
     */
    private List<T> data;

    public PageVO() {
    }

    public PageVO(Integer pageSize, Integer pageNum, Long total, List<T> data) {
        this.pageSize = pageSize;
        this.pageNum = pageNum;
        this.total = total;
        this.data = data;
    }
}

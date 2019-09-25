package com.chaohen.fund.analysis.service;

import com.chaohen.fund.analysis.vo.PageVO;
import com.chaohen.fund.analysis.vo.uservo.FundUserVO;

/**
 * 用户服务接口
 *
 * @author chaohen
 * @date 2019/9/25
 */
public interface FundUserService {
    PageVO<FundUserVO> selectUserList(Integer pageNum, Integer pageSize);
}

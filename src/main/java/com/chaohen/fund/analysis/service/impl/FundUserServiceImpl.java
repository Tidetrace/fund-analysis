package com.chaohen.fund.analysis.service.impl;

import com.chaohen.fund.analysis.dao.FundUserMapper;
import com.chaohen.fund.analysis.domain.FundUser;
import com.chaohen.fund.analysis.service.FundUserService;
import com.chaohen.fund.analysis.utils.OrikaMapperUtils;
import com.chaohen.fund.analysis.vo.PageVO;
import com.chaohen.fund.analysis.vo.uservo.FundUserVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 用户服务实现
 *
 * @author chaohen
 * @date 2019/9/25
 */
@Service
public class FundUserServiceImpl implements FundUserService {
    @Autowired
    private FundUserMapper fundUserMapper;

    @Override
    public PageVO<FundUserVO> selectUserList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<FundUser> fundUsers = fundUserMapper.selectAll();
        PageInfo<FundUser> pageInfo = new PageInfo<>(fundUsers);
        List<FundUserVO> scheduleDtoList = OrikaMapperUtils.mapList(fundUsers, FundUser.class, FundUserVO.class);
        return new PageVO<>(pageSize, pageNum, pageInfo.getTotal(), scheduleDtoList);
    }
}

package com.chaohen.fund.analysis.dao;

import com.chaohen.fund.analysis.domain.FundUser;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface FundUserMapper {
    int insert(FundUser record);

    List<FundUser> selectAll();
}
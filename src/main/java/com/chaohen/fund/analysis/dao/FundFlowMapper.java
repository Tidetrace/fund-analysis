package com.chaohen.fund.analysis.dao;

import com.chaohen.fund.analysis.domain.FundFlow;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface FundFlowMapper {
    int insert(FundFlow record);

    List<FundFlow> selectAll();
}
package com.chaohen.fund.analysis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.chaohen.fund.analysis.dao"})
public class FundAnalysisApplication {

    public static void main(String[] args) {
        SpringApplication.run(FundAnalysisApplication.class, args);
    }

}

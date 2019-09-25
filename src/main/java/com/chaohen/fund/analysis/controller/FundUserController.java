package com.chaohen.fund.analysis.controller;

import com.chaohen.fund.analysis.service.FundUserService;
import com.chaohen.fund.analysis.vo.PageVO;
import com.chaohen.fund.analysis.vo.Result;
import com.chaohen.fund.analysis.vo.uservo.FundUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制器
 *
 * @author chaohen
 * @date 2019/9/25
 */
@RestController
@RequestMapping("/fund/")
public class FundUserController {

    @Autowired
    private FundUserService fundUserService;

    @PostMapping("/list")
    public Result list(@RequestParam(name = "pageNum", defaultValue = "1", required = false) Integer pageNum,
                       @RequestParam(name = "pageSize", defaultValue = "10", required = false) Integer pageSize) {
        PageVO<FundUserVO> pageVO = fundUserService.selectUserList(pageNum, pageSize);
        return Result.success(pageVO);
    }
}

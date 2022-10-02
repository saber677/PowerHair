package com.powerhair.backgroundhair.module.member.controller;

import com.powerhair.backgroundhair.module.member.model.dto.MemberAddDTO;
import com.powerhair.backgroundhair.module.member.service.MemberService;
import com.powerhair.backgroundhair.tool.entity.Result;
import com.powerhair.backgroundhair.tool.util.ResultUtil;
import com.powerhair.backgroundhair.tool.util.UserContextUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "成员相关操作")
@RestController
@RequestMapping(value = "/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping(value = "/")
    @ApiOperation(value = "添加成员")
    public Result addMembers(@RequestBody MemberAddDTO memberAddDTO) {
        memberAddDTO.setAccountId(UserContextUtil.getAccountId());
        memberService.save(memberAddDTO);
        return ResultUtil.success();
    }
}

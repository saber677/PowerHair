package com.powerhair.backgroundhair.module.member.controller;

import com.powerhair.backgroundhair.module.member.model.dto.MemberAddDTO;
import com.powerhair.backgroundhair.module.member.model.dto.MemberModifyDTO;
import com.powerhair.backgroundhair.module.member.model.vo.MemberPositionVO;
import com.powerhair.backgroundhair.module.member.service.MemberService;
import com.powerhair.backgroundhair.tool.entity.Result;
import com.powerhair.backgroundhair.tool.util.ResultUtil;
import com.powerhair.backgroundhair.tool.util.UserContextUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping(value = "/")
    @ApiOperation(value = "修改成员信息")
    public Result modifyMember(@RequestBody MemberModifyDTO memberModifyDTO) {
        memberModifyDTO.setAccountId(UserContextUtil.getAccountId());
        memberService.update(memberModifyDTO);
        return ResultUtil.success();
    }

    @DeleteMapping(value = "/batch")
    @ApiOperation(value = "批量删除成员")
    public Result deleteBatch(@ApiParam(value = "成员ID集合") @RequestParam(value = "memberIds") List<Long> memberIds) {
        memberService.deleteBatch(memberIds);
        return ResultUtil.success();
    }

    @GetMapping(value = "/position")
    @ApiOperation(value = "获取成员职位列表")
    public Result<MemberPositionVO> getMemberPosition() {
        return ResultUtil.success(memberService.getMemberPosition());
    }

    @GetMapping(value = "/list")
    @ApiOperation(value = "获取成员列表")
    public Result<MemberListVO> getMemberList(@ApiParam(value = "成员名字，模糊搜索") @RequestParam(value = "memberName", required = false) String memberName,
                                          @ApiParam(value = "店铺ID") @RequestParam(value = "storeId") Long storeId,
                                          @ApiParam(value = "size") @RequestParam(value = "size", required = false, defaultValue = "20") Integer size,
                                          @ApiParam(value = "page") @RequestParam(value = "page", required = false, defaultValue = "1") Integer page) {
        return ResultUtil.success(memberService.listByStoreId(storeId, memberName, size, page));
    }
}

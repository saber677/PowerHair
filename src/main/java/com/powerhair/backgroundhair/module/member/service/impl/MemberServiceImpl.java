package com.powerhair.backgroundhair.module.member.service.impl;

import com.powerhair.backgroundhair.module.member.domain.Member;
import com.powerhair.backgroundhair.module.member.mapper.MemberMapper;
import com.powerhair.backgroundhair.module.member.model.dto.MemberAddDTO;
import com.powerhair.backgroundhair.module.member.model.enums.MemberPositionEnum;
import com.powerhair.backgroundhair.module.member.service.MemberService;
import com.powerhair.backgroundhair.tool.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public void save(MemberAddDTO memberAddDTO) {
        Member member = new Member();
        member.setId(UUIDUtil.getPrimaryKey());
        member.setMemberName(memberAddDTO.getMemberName());
        member.setMemberPosition(MemberPositionEnum.getByObj(memberAddDTO.getMemberPosition()));
        member.setStatus(memberAddDTO.getStatus());
        member.setCreateTime(new Date());
        memberMapper.save(member);
    }
}

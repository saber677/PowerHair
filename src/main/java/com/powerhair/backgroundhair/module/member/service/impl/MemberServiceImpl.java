package com.powerhair.backgroundhair.module.member.service.impl;

import com.powerhair.backgroundhair.module.member.domain.Member;
import com.powerhair.backgroundhair.module.member.mapper.MemberMapper;
import com.powerhair.backgroundhair.module.member.model.dto.MemberAddDTO;
import com.powerhair.backgroundhair.module.member.model.enums.MemberPositionEnum;
import com.powerhair.backgroundhair.module.member.service.MemberService;
import com.powerhair.backgroundhair.tool.util.IdEnumUtil;
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
        Member member = Member.builder()
                .id(UUIDUtil.getPrimaryKey())
                .storeId(memberAddDTO.getStoreId())
                .memberName(memberAddDTO.getMemberName())
                .memberPosition(IdEnumUtil.getByObj(memberAddDTO.getMemberPosition()))
                .createTime(new Date())
                .build();
        memberMapper.save(member);
    }

    @Override
    public Integer countByStoreId(Long storeId) {
        return memberMapper.countByStoreId(storeId);
    }
}

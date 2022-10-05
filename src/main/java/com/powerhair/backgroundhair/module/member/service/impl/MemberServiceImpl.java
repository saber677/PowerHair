package com.powerhair.backgroundhair.module.member.service.impl;

import com.google.common.collect.Lists;
import com.powerhair.backgroundhair.module.member.domain.Member;
import com.powerhair.backgroundhair.module.member.mapper.MemberMapper;
import com.powerhair.backgroundhair.module.member.model.dto.MemberAddDTO;
import com.powerhair.backgroundhair.module.member.model.dto.MemberModifyDTO;
import com.powerhair.backgroundhair.module.member.model.enums.MemberPositionEnum;
import com.powerhair.backgroundhair.module.member.model.vo.MemberPositionVO;
import com.powerhair.backgroundhair.module.member.service.MemberService;
import com.powerhair.backgroundhair.tool.util.IdEnumUtil;
import com.powerhair.backgroundhair.tool.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

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

    @Override
    public List<Member> listByStoreId(Long storeId) {
        return memberMapper.listByStoreId(storeId);
    }

    @Override
    public Integer update(MemberModifyDTO memberModifyDTO) {
        Member member = Member.builder()
                .id(memberModifyDTO.getMemberId())
                .memberName(memberModifyDTO.getMemberName())
                .memberPosition(IdEnumUtil.getByObj(memberModifyDTO.getMemberPosition()))
                .build();
        return memberMapper.update(member);
    }

    @Override
    public Integer deleteBatch(List<Long> memberIds) {
        return memberMapper.deleteBatch(memberIds);
    }

    @Override
    public List<MemberPositionVO> getMemberPosition() {

        List<MemberPositionVO> memberPositionList = Lists.newArrayList();

        for (MemberPositionEnum value : MemberPositionEnum.values()) {
            memberPositionList.add(MemberPositionVO.builder()
                    .name(value.name())
                    .id(value.getId())
                    .desc(value.getDesc())
                    .build());
        }
        return memberPositionList;
    }
}

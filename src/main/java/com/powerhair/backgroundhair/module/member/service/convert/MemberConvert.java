package com.powerhair.backgroundhair.module.member.service.convert;

import com.powerhair.backgroundhair.module.member.domain.Member;
import com.powerhair.backgroundhair.module.member.model.vo.MemberVO;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MemberConvert {

    public static MemberVO toVO(Member member) {
        return MemberVO.builder()
                .id(member.getId())
                .memberName(member.getMemberName())
                .memberPosition(member.getMemberPosition())
                .createTime(member.getCreateTime())
                .build();
    }

    public static List<MemberVO> toVOList(List<Member> members) {

        if (CollectionUtils.isEmpty(members)) {
            return Collections.EMPTY_LIST;
        }

        return members.stream()
                .map(MemberConvert::toVO)
                .collect(Collectors.toList());
    }
}


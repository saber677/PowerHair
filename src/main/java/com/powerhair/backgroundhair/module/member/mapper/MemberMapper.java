package com.powerhair.backgroundhair.module.member.mapper;

import com.powerhair.backgroundhair.module.member.domain.Member;
import org.apache.ibatis.annotations.Param;

public interface MemberMapper {

    int save(@Param("param")Member member);

}

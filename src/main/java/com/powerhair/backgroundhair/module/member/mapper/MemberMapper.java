package com.powerhair.backgroundhair.module.member.mapper;

import com.powerhair.backgroundhair.module.member.domain.Member;
import org.apache.ibatis.annotations.Param;

public interface MemberMapper {

    Integer countByStoreId(@Param("storeId") Long storeId);

    int save(Member member);

}

package com.powerhair.backgroundhair.module.member.mapper;

import com.powerhair.backgroundhair.module.member.domain.Member;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemberMapper {

    List<Member> listByStoreId(@Param("storeId") Long storeId);

    Integer countByStoreId(@Param("storeId") Long storeId);

    int save(Member member);

}

package com.powerhair.backgroundhair.module.member.mapper;

import com.powerhair.backgroundhair.module.member.domain.Member;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemberMapper {

    int deleteBatch(@Param("memberIds") List<Long> memberIds);

    int update(Member member);

    List<Member> listByStoreId(@Param("storeId") Long storeId);

    Integer countByStoreId(@Param("storeId") Long storeId);

    int save(Member member);

}

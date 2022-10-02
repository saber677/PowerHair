package com.powerhair.backgroundhair.module.member.service;

import com.powerhair.backgroundhair.module.member.domain.Member;
import com.powerhair.backgroundhair.module.member.model.dto.MemberAddDTO;

import java.util.List;

public interface MemberService {

    List<Member> listByStoreId(Long storeId);

    Integer countByStoreId(Long storeId);

    void save(MemberAddDTO memberAddDTO);

}

package com.powerhair.backgroundhair.module.member.service;

import com.powerhair.backgroundhair.module.member.model.dto.MemberAddDTO;

public interface MemberService {

    Integer countByStoreId(Long storeId);

    void save(MemberAddDTO memberAddDTO);

}

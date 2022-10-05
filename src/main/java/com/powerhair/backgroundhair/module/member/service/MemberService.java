package com.powerhair.backgroundhair.module.member.service;

import com.powerhair.backgroundhair.module.member.domain.Member;
import com.powerhair.backgroundhair.module.member.model.dto.MemberAddDTO;
import com.powerhair.backgroundhair.module.member.model.dto.MemberModifyDTO;
import com.powerhair.backgroundhair.module.member.model.vo.MemberPositionVO;

import java.util.List;

public interface MemberService {

    List<MemberPositionVO> getMemberPosition();

    Integer deleteBatch(List<Long> memberIds);

    Integer update(MemberModifyDTO memberModifyDTO);

    List<Member> listByStoreId(Long storeId);

    Integer countByStoreId(Long storeId);

    void save(MemberAddDTO memberAddDTO);

}

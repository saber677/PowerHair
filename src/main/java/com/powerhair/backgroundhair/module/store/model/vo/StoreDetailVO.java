package com.powerhair.backgroundhair.module.store.model.vo;

import com.powerhair.backgroundhair.module.member.domain.Member;
import com.powerhair.backgroundhair.module.member.model.vo.MemberVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
@ApiModel
public class StoreDetailVO {

    private Long id;

    private String storeName;

    @ApiModelProperty(value = "店铺成员数量")
    private Integer memberCount;

    private Date createTime;

    private Date updateTime;

    private Long updatorId;

    private Long creatorId;

    @ApiModelProperty(value = "店铺成员信息")
    private List<Member> storeMembers;
}

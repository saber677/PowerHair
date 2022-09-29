package com.powerhair.backgroundhair.module.member.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    private Long id;

    private Long storeId;

    private String memberName;

    private Integer memberPosition;

    private Date createTime;

}

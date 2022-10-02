package com.powerhair.backgroundhair.module.store.domain;

import lombok.*;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Store {

    private Long id;

    private String storeName;

    private Date createTime;

    private Date updateTime;

    private Long updatorId;

    private Long creatorId;
}

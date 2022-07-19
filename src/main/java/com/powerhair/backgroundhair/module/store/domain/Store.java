package com.powerhair.backgroundhair.module.store.domain;

import lombok.*;

import java.util.Date;

@Getter
@Setter
public class Store {

    private Long id;

    private String name;

    private Date createTime;

    private Date updateTime;

    private Long updatorId;

    private Long creatorId;
}

package com.powerhair.backgroundhair.module.console.domain;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class Account implements Serializable {

    private Long id;

    private Long storeId;

    private String username;

    private String password;

    private String name;

    private Date createTime;

    private Long creatorId;

    private Date updateTime;

    private Long updatorId;

}

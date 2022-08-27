package com.powerhair.backgroundhair.module.console.domain;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account implements Serializable {

    private Long id;

    private String username;

    private String password;

    private Integer auth;

    private String description;

    private Date createTime;

    private Long creatorId;

    private Date updateTime;

    private Long updatorId;

}

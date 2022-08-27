package com.powerhair.backgroundhair.module.console.mapper;

import com.powerhair.backgroundhair.module.console.domain.Account;
import org.apache.ibatis.annotations.Param;

public interface ConsoleAccountMapper {

    Account getByUserName(@Param(value = "username") String username);

    /**
     * 通过ID获取账号对象
     *
     * @return
     */
    Account getById(@Param(value = "accountId") Long id);

    /**
     * 插入account对象
     *
     * @param account
     * @return
     */
    int save(Account account);
}

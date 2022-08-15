package com.powerhair.backgroundhair.module.console.service;

import com.powerhair.backgroundhair.module.console.model.dto.AccountDTO;
import com.powerhair.backgroundhair.utils.entity.Result;

public interface ConsoleAccountService {

    /**
     * 登录
     *
     * @param accountDTO
     * @return
     */
    Result login(AccountDTO accountDTO);

}

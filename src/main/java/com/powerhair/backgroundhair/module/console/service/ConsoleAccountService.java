package com.powerhair.backgroundhair.module.console.service;

import com.powerhair.backgroundhair.module.console.model.dto.RegisterDTO;
import com.powerhair.backgroundhair.utils.entity.Result;

public interface ConsoleAccountService {

    /**
     * 注册
     *
     * @param registerDTO
     * @return
     */
    Result register(RegisterDTO registerDTO);

}

package com.powerhair.backgroundhair.module.console.service;

import com.powerhair.backgroundhair.module.console.model.dto.RegisterDTO;
import com.powerhair.backgroundhair.utils.entity.Result;

public interface ConsoleAccountService {

    Result register(RegisterDTO registerDTO);

}

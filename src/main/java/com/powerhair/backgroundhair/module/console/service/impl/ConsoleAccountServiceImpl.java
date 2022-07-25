package com.powerhair.backgroundhair.module.console.service.impl;

import com.powerhair.backgroundhair.module.console.domain.Account;
import com.powerhair.backgroundhair.module.console.mapper.ConsoleAccountMapper;
import com.powerhair.backgroundhair.module.console.model.dto.AccountDTO;
import com.powerhair.backgroundhair.module.console.service.ConsoleAccountService;
import com.powerhair.backgroundhair.utils.entity.Result;
import com.powerhair.backgroundhair.utils.util.ResultUtil;
import com.powerhair.backgroundhair.utils.util.UUIDUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.security.MD5Encoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.security.provider.MD5;

import java.util.Date;

@Service
public class ConsoleAccountServiceImpl implements ConsoleAccountService {

    private static final Logger logger = LoggerFactory.getLogger(ConsoleAccountServiceImpl.class);
    @Autowired
    ConsoleAccountMapper consoleAccountMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result register(AccountDTO accountDTO) {

        try {
            Account account = new Account();
            account.setId(UUIDUtil.getPrimaryKey());
            account.setUsername(accountDTO.getUsername());
            account.setPassword(accountDTO.getPassword());
            account.setCreateTime(new Date());
            account.setUpdateTime(new Date());

            consoleAccountMapper.save(account);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage());
        }

        return ResultUtil.success();
    }

    @Override
    public Result login(AccountDTO accountDTO) {

        Account account = consoleAccountMapper.getByUserName(accountDTO.getUsername());

        if (!StringUtils.equals(account.getPassword(), accountDTO.getPassword())) {
            throw new RuntimeException("密码错误");
        }
        return ResultUtil.success();
    }
}

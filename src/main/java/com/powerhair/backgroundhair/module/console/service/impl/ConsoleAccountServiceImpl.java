package com.powerhair.backgroundhair.module.console.service.impl;

import com.alibaba.druid.support.json.JSONUtils;
import com.powerhair.backgroundhair.module.console.domain.Account;
import com.powerhair.backgroundhair.module.console.mapper.ConsoleAccountMapper;
import com.powerhair.backgroundhair.module.console.model.dto.AccountDTO;
import com.powerhair.backgroundhair.module.console.model.vo.SessionVO;
import com.powerhair.backgroundhair.module.console.service.ConsoleAccountService;
import com.powerhair.backgroundhair.utils.entity.Result;
import com.powerhair.backgroundhair.utils.util.MD5Util;
import com.powerhair.backgroundhair.utils.util.ResultUtil;
import com.powerhair.backgroundhair.utils.util.UUIDUtil;
import io.swagger.util.Json;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

@Service
public class ConsoleAccountServiceImpl implements ConsoleAccountService {

    private static final Logger logger = LoggerFactory.getLogger(ConsoleAccountServiceImpl.class);

    @Autowired
    private ConsoleAccountMapper consoleAccountMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result createAccount(AccountDTO accountDTO) {

        try {
            if (!Objects.isNull(consoleAccountMapper.getByUserName(accountDTO.getUsername()))) {
                throw new RuntimeException("已经存在相同的账号名称，请更换别的账号名");
            }
            Account account = new Account();
            account.setId(UUIDUtil.getPrimaryKey());
            account.setUsername(accountDTO.getUsername());
            account.setPassword(MD5Util.encryptKey(accountDTO.getPassword()));
            account.setAuth(accountDTO.getAuth());
            account.setDescription(accountDTO.getDescription());
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

        Account account = null;
        try {
            account = consoleAccountMapper.getByUserName(accountDTO.getUsername());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

        if (Objects.isNull(account)) {
            throw new RuntimeException("账号不存在");
        }

        if (!StringUtils.equals(account.getPassword(), MD5Util.encryptKey(accountDTO.getPassword()))) {
            throw new RuntimeException("密码错误");
        }

        SessionVO build = SessionVO.builder().token(String.valueOf(account.getId())).build();
        return ResultUtil.success(build);
    }
}

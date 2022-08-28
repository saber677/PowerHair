package com.powerhair.backgroundhair.utils.util;

import lombok.Data;

import java.util.Objects;

public class UserContextUtil {

    private static ThreadLocal<AccountInfo> threadLocal = new ThreadLocal<>();

    public static Long getAccountId() {
        if (Objects.isNull(threadLocal.get())) {
            return null;
        }
        return threadLocal.get().getAccountId();
    }

    public static void setAccountId(Long accountId) {
        AccountInfo accountInfo = threadLocal.get();
        if (Objects.isNull(accountInfo)) {
            accountInfo = new AccountInfo();
            threadLocal.set(accountInfo);
        }
        accountInfo.setAccountId(accountId);
    }

    public static void clear() {
        threadLocal.remove();
    }

    @Data
    public static class AccountInfo {
        private Long accountId;
    }
}
